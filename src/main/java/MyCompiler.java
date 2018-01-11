import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.RecognitionException;

import java.util.*;


public class MyCompiler extends CCompilerBaseVisitor<Void>{

    private static PrintStream outputFile;
    private String indent = "";

    private MyCompiler(PrintStream output) {
        outputFile = output;
    }

    public static void main(String args[]) throws IOException {
        String name;
        Scanner inputName = new Scanner(System.in);
        FileInputStream c;
        PrintStream py;

        System.out.println("Enter the name of the program (without \".c\" extension):");

        name = inputName.next();
        c = new FileInputStream(name + ".c");
        py  = new PrintStream(new File(name + ".py"));
        try {
            ANTLRInputStream input = new ANTLRInputStream(c);
            CCompilerLexer lexer = new CCompilerLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CCompilerParser parser = new CCompilerParser(tokens);
            ParseTree tree = parser.prog();

            MyCompiler compiler = new MyCompiler(py);
            compiler.visit(tree);
        } catch (RecognitionException e ){
            System.out.println(name + ".c ilegal");
            e.printStackTrace();
            return ;
        }
        if(!haveMain){
            throw new MyException("No Main");
        }
        outputFile.println("if __name__ == '__main__':");
        outputFile.println("  main()");

        py.flush();
    }

    private void append(String s) {
        outputFile.print(s);
    }

    private void appendLine(String s) {
        outputFile.print(indent + s);
    }

    private void endLine(String s) {
        outputFile.println(s);
    }

    private void endLine() {
        endLine("");
    }

    private void incIndent() {
        indent += "  ";
    }

    private void decIndent() {
        indent = indent.substring(0, indent.length() - 2);
    }

    private boolean inMain = false;
    private boolean printing = false;
    private boolean inFunc = false;
    private static boolean haveMain = false;
    private Map<String,String> local_var_set  = null;
    private Map<String,String> global_var_set = null;
    private Map<String,String> struct_map;
    private Set<String> type_name_set = new HashSet<>();
    private Map<String,Map<String,String>> type_attr_map = new HashMap<>();

    private void var_def(String varname){
        if(inFunc){
            if((var_check(varname) & 1) != 0){
                throw new MyException("variable "+ varname +" redefined!");
            }
            local_var_set.put(varname,"");
        }
        else{
            if((var_check(varname) & 3) != 0){
                throw new MyException("variable "+ varname +" redefined!");
            }
            global_var_set.put(varname,"");
        }
    }

    private void var_def(String varname,String type){
        if(inFunc){
            if((var_check(varname) & 1) != 0){
                throw new MyException("variable "+ varname +" redefined!");
            }
            local_var_set.put(varname,type);
        }
        else{
            if((var_check(varname) & 3) != 0){
                throw new MyException("variable "+ varname +" redefined!");
            }
            global_var_set.put(varname,type);
        }
    }

    private int var_check(String varname){
        int res = 0;
        if(local_var_set.get(varname) != null) {
            res |= 1;
        }
        if(global_var_set.get(varname) != null){
            res |= 2;
        }
        return res;
    }

    private void set_local_init(){
        if (local_var_set == null) {
            local_var_set = new HashMap<>();
        }
        local_var_set.clear();
    }


    private void set_global_init(){
        if (global_var_set == null) {
            global_var_set = new HashMap<>();
        }
        global_var_set.clear();
    }


    private void type_check(CCompilerParser.ComplexTypeContext type){
        if(type.myTypeName() == null){
            return;
        }
        if(type_attr_map.get(type.myTypeName().getText()) == null && !type_name_set.contains(type.myTypeName().getText())){
            throw new MyException("unknown type : " + type.getText());
        }
    }


     @Override public Void visitProg(CCompilerParser.ProgContext ctx){
         set_global_init();
        return visitChildren(ctx);
    }

    @Override public Void visitFunctionDefine(CCompilerParser.FunctionDefineContext ctx) {
        set_local_init();
        inMain = ctx.functionTitle().functionName().getText().equals("main");
        if(inMain){
            haveMain = true;
        }
        inFunc = true;
        visitChildren(ctx);
        inFunc = false;
        indent = "";
        return null;
    }

    @Override public Void visitTypedefTreatment(CCompilerParser.TypedefTreatmentContext ctx) {
        type_name_set.add(ctx.myTypeName().getText());
        return null;
    }

    @Override public Void visitComplexType(CCompilerParser.ComplexTypeContext ctx) {
        if(ctx.myTypeName() == null){
            append(ctx.TYPE().getText());
            return null;
        }
        return visit(ctx.myTypeName());
    }

    @Override public Void visitStructTreatment(CCompilerParser.StructTreatmentContext ctx) {
        struct_map = new HashMap<>();

        type_attr_map.put(ctx.myTypeName().getText(),struct_map);
        appendLine("class " + ctx.myTypeName().getText() + ":\n  def __init__(self):\n    return\n\n" );
        visit(ctx.structblock());
        return null;
    }

    @Override public Void visitMyTypeName(CCompilerParser.MyTypeNameContext ctx) {
        if(!type_name_set.contains(ctx.getText())){
            throw new MyException("type "+ ctx.IDENTIFIER().getText() +" undefined!");
        }
        else{
            append(ctx.IDENTIFIER().getText());
        }
        return visitChildren(ctx);
    }

    @Override public Void visitStructblock(CCompilerParser.StructblockContext ctx) { return visitChildren(ctx); }

    @Override public Void visitAttrDefine(CCompilerParser.AttrDefineContext ctx) {
        String attrtype = ( ctx.complexType().myTypeName() == null ) ? ctx.complexType().TYPE().getText() : ctx.complexType().myTypeName().getText();
        String attrname = ctx.IDENTIFIER().getText();
        struct_map.put(attrname,attrtype);
        return null;
    }
    
    @Override public Void visitFunctionTitle(CCompilerParser.FunctionTitleContext ctx) {
        visit(ctx.functionType());
        append("def " + ctx.functionName().getText() + "(");
        visit(ctx.functionParams());
        endLine("):");
        return null;
    }

    @Override public Void visitFunctionBlock(CCompilerParser.FunctionBlockContext ctx) {
        incIndent();
        visitChildren(ctx);
        decIndent();
        append("\n\n");
        return null;
    }

     @Override public Void visitFunctionType(CCompilerParser.FunctionTypeContext ctx) {
        if(ctx.VOID() == null) {
            type_check(ctx.complexType());
        }
        return null;
    }

    @Override public Void visitFunctionParams(CCompilerParser.FunctionParamsContext ctx) {
        List<CCompilerParser.ParamContext> params = ctx.param();
        for(int i = 0 ; i < params.size() ; i ++){
            if(i > 0){
                append(", ");
            }
            visit(params.get(i));
        }
        return null;
    }

    @Override public Void visitParam(CCompilerParser.ParamContext ctx) {
        type_check(ctx.complexType());
        var_def(ctx.IDENTIFIER().getText(),ctx.complexType().getText());
        append(ctx.IDENTIFIER().getText());
        return null;
    }

    @Override public Void visitControlExpression(CCompilerParser.ControlExpressionContext ctx) {
        visitChildren(ctx);
        if(ctx.CONTINUE() != null){
            if(!syncmd_stack.empty())
                visit(syncmd_stack.peek());
            appendLine("continue");
            endLine();
        }
        if(ctx.BREAK() != null){
            if(!syncmd_stack.empty())
                visit(syncmd_stack.peek());
            appendLine("break");
            endLine();
        }
        return null;
    }

    private Stack<CCompilerParser.AssignExpressionContext> syncmd_stack = new Stack<>();
    @Override public Void visitForExpression(CCompilerParser.ForExpressionContext ctx) {
        visitForTitle(ctx.forTitle());
        syncmd_stack.push(ctx.forTitle().assignExpression(1));
        visit(ctx.block());
        incIndent();
        visit(syncmd_stack.pop());
        decIndent();
        endLine();
        return null;
    }

    @Override public Void visitForTitle(CCompilerParser.ForTitleContext ctx) {
        visit(ctx.assignExpression(0));
        appendLine("while ");
        visit(ctx.valueExpression());
        endLine(":");
        return null;
    }

    @Override public Void visitBlock(CCompilerParser.BlockContext ctx) {
        incIndent();
        visitChildren(ctx);
        decIndent();
        return null;
    }

    @Override public Void visitReturnExpression(CCompilerParser.ReturnExpressionContext ctx) {
        appendLine("return");
        if(!inMain) {
            append(" ");
            visitChildren(ctx);
        }
        endLine();
        return null;
    }

    @Override public Void visitWhileExpression(CCompilerParser.WhileExpressionContext ctx) {
         appendLine("");
         visitChildren(ctx);
         return null;
    }

    @Override public Void visitWhileTitle(CCompilerParser.WhileTitleContext ctx) {
        append("while ");
        visitChildren(ctx);
        endLine(":");
        return  null;
    }

    @Override public Void visitIfExpression(CCompilerParser.IfExpressionContext ctx) {
        appendLine("");
        return visitChildren(ctx);
    }

    @Override public Void visitIfTitle(CCompilerParser.IfTitleContext ctx) {
        append("if ");
        visitChildren(ctx);
        endLine(":");
        return  null;
    }

    @Override public Void visitElseifTitle(CCompilerParser.ElseifTitleContext ctx) {
        append("elif ");
        visitChildren(ctx);
        endLine(":");
        return  null;
    }


    @Override public Void visitElseTitle(CCompilerParser.ElseTitleContext ctx) {
        appendLine("");
        endLine("else: ");
        return null;
    }

    @Override public Void visitDefineExpression(CCompilerParser.DefineExpressionContext ctx) {
        return visitChildren(ctx);
    }

    private String typename = "";

    @Override public Void visitVariableName(CCompilerParser.VariableNameContext ctx) {
        if(ctx.op != null) {
            visit(ctx.variableName());
            int len = typename.length();
            if(typename.charAt(len - 1) == '*'){
                typename = typename.substring(0,len - 1);
                if(!ctx.op.getText().equals("->")){
                    throw new MyException("pointer error (should be ->) :" + ctx.getParent().getText());
                }
            }
            else if(!ctx.op.getText().equals(".")){
                throw new MyException("pointer error (should be .) :" + ctx.getParent().getText());
            }
            if(type_attr_map.get(typename) == null){
                throw new MyException("type " + typename + " don't have " + ctx.IDENTIFIER().getText() );
            }
            String tmp = type_attr_map.get(typename).get(ctx.IDENTIFIER().getText());
            if(tmp == null){
                throw new MyException("type " + typename + " don't have " + ctx.IDENTIFIER().getText() );
            }
            typename = tmp;
            append("." + ctx.IDENTIFIER().getText());
        }
        else
        {
            if (var_check(ctx.IDENTIFIER().getText()) == 0) {
                throw new MyException("variable " + ctx.IDENTIFIER().getText() + " undefined ");
            }
            if(ctx.variableName() != null ){
                append(ctx.IDENTIFIER().getText() + '[');
                visit(ctx.variableName());
                append("]");
            }
            else if(ctx.valueExpression() != null ){
                append(ctx.IDENTIFIER().getText() + '[' );
                visit(ctx.valueExpression());
                append("]");
            }
            else{
                append(ctx.getText());
            }
            typename = local_var_set.get(ctx.IDENTIFIER().getText());
            if(typename == null ){
                typename =  global_var_set.get(ctx.IDENTIFIER().getText());
            }
        }
        return null;
    }

    @Override public Void visitVarDefineWithInit(CCompilerParser.VarDefineWithInitContext ctx) {
        type_check(ctx.complexType());
        var_def(ctx.IDENTIFIER().getText(),ctx.complexType().getText());
        appendLine(ctx.IDENTIFIER().getText() + " = " );
        if(ctx.complexType().myTypeName() != null) {
            visit(ctx.complexType());
            append("(");
            visit(ctx.valueExpression());
            endLine(")");
        }
        else{
            visit(ctx.valueExpression());
            endLine();
        }
        return null;
    }


    @Override public Void visitVarDefineWithoutInit(CCompilerParser.VarDefineWithoutInitContext ctx) {
        type_check(ctx.complexType());
        var_def(ctx.IDENTIFIER().getText(),ctx.complexType().getText());
        if(ctx.complexType().myTypeName() != null && type_attr_map.get(ctx.complexType().myTypeName().getText()) != null) {
            appendLine("");
            endLine(ctx.IDENTIFIER().getText() + " = " + ctx.complexType().myTypeName().getText() + "()");
        }
        return null;
    }

    @Override public Void visitArrayDefine(CCompilerParser.ArrayDefineContext ctx) {
        type_check(ctx.complexType());
        var_def(ctx.IDENTIFIER().getText(),ctx.complexType().getText() + "*");
        if(ctx.complexType().TYPE() != null && ctx.complexType().TYPE().getText().equals("char") ){
            if(ctx.STRING() != null) {
                appendLine(ctx.IDENTIFIER().getText() + " = " + ctx.STRING());
                endLine();
            }
            else{
                appendLine(ctx.IDENTIFIER().getText() + " = \"\"" );
                endLine();
            }
        }
        else if (ctx.list() == null){
            String bit = ctx.complexType().myTypeName() == null ? "0" : ctx.complexType().myTypeName().getText() +"()";
            appendLine(ctx.IDENTIFIER().getText() + " = [" + bit + "]*" + ctx.CONSTANT().getText());
            endLine();
        }
        else{
            appendLine(ctx.IDENTIFIER().getText() + " = ");
            visit(ctx.list());
            endLine();
        }
        return null;
    }

    @Override public Void visitList(CCompilerParser.ListContext ctx) {
        List<TerminalNode> constant= ctx.CONSTANT();
        append("[");
        for(int i = 0  ; i < constant.size() ; i ++){
            if(i > 0){
                append(", ");
            }
            append(constant.get(i).getText());
        }
        append("]");
        return visitChildren(ctx);
    }

    private int inAssign = 0;
    @Override public Void visitBinaryAssign(CCompilerParser.BinaryAssignContext ctx) {
        if (var_check(ctx.variableName().IDENTIFIER().getText()) == 0 && ctx.variableName().op == null) {
            throw new MyException("variable " + ctx.variableName().IDENTIFIER().getText() + " undefined ");
        }
        appendLine("");
        inAssign = 1;
        if(ctx.variableName().op == null ){
            String type =  local_var_set.get(ctx.variableName().IDENTIFIER().getText());
            if(type == null){
                type = global_var_set.get(ctx.variableName().IDENTIFIER().getText());
            }
            if(type.equals("char*")){
                append(ctx.variableName().IDENTIFIER().getText() + " = ");
                if(ctx.variableName() != null ){
                    append(ctx.variableName().IDENTIFIER().getText() + "[:" );
                    visit(ctx.variableName().variableName());
                    append("] +" );
                    visit(ctx.valueExpression());
                    append(" + ");
                    append(ctx.variableName().IDENTIFIER().getText() + "[1+");
                    visit(ctx.variableName().variableName());
                    append(":]");
                }
                else if(ctx.valueExpression() != null ){
                    append(ctx.variableName().IDENTIFIER().getText() + "[:" );
                    visit(ctx.variableName().valueExpression());
                    append("] +" );
                    visit(ctx.valueExpression());
                    append(" + ");
                    append(ctx.variableName().IDENTIFIER().getText() + "[1+");
                    visit(ctx.variableName().valueExpression());
                    append(":]");
                }
                endLine();
                return null;
            }
        }
        visit(ctx.variableName());
        inAssign = 0;
        append(" = ");
        visit(ctx.valueExpression());
        endLine();
        return null;
    }

    @Override public Void visitUnaryAssign(CCompilerParser.UnaryAssignContext ctx) {
        appendLine("");
        visitChildren(ctx);
        if (ctx.op.getText().equals("++"))
            endLine(" += 1");
        else if (ctx.op.getText().equals("--"))
            endLine(" -= 1");
        return null;
    }

    @Override public Void visitCallAssign(CCompilerParser.CallAssignContext ctx) {
        appendLine("");
        visitChildren(ctx);
        endLine();
        return null;
    }
    @Override public Void visitValExpr(CCompilerParser.ValExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitCmpExpr(CCompilerParser.CmpExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitStringExpr(CCompilerParser.StringExprContext ctx) {
        append(ctx.getText());
        return visitChildren(ctx);
    }

    @Override public Void visitCharExpr(CCompilerParser.CharExprContext ctx) {
        append(ctx.getText());
        return visitChildren(ctx);
    }

    @Override public Void visitVarVExpr(CCompilerParser.VarVExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitCharVExpr(CCompilerParser.CharVExprContext ctx) {
        append(ctx.getText());
        return visitChildren(ctx);
    }

    @Override public Void visitConstVExpr(CCompilerParser.ConstVExprContext ctx) {
        append(ctx.getText());
        return null;
    }

    @Override public Void visitBinaryVExpr(CCompilerParser.BinaryVExprContext ctx) {
        if(ctx.op.getText().equals("-")){
            if(ctx.vExpr(1).getText().equals("'0'")) {
                append("int(");
                visit(ctx.vExpr(0));
                append(")");
                return null;
            }
        }
        visit(ctx.vExpr(0));
        append(" " + ctx.op.getText() + " ");
        visit(ctx.vExpr(1));
        return null;
    }

    @Override public Void visitCallVExpr(CCompilerParser.CallVExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitBracketsVExpr(CCompilerParser.BracketsVExprContext ctx) {
        append("(");
        visitChildren(ctx);
        append(")");
        return null;
    }

    @Override public Void visitCExpr(CCompilerParser.CExprContext ctx) {
        List<CCompilerParser.CunitExprContext> param = ctx.cunitExpr();
        for(int i = 0 ; i < param.size() ; i ++) {
            if (i > 0) {
                if (ctx.op.getText().equals("||"))
                    append(" or ");
                else
                    append(" and ");
            }
            visit(param.get(i));
        }
        return null;
    }

    @Override public Void visitBinaryCExpr(CCompilerParser.BinaryCExprContext ctx) {

        visit(ctx.vExpr(0));
        append(" " + ctx.op.getText() + " ");
        visit(ctx.vExpr(1));
        return null;
    }

    @Override public Void visitCallCExpr(CCompilerParser.CallCExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Void visitBracketCExpr(CCompilerParser.BracketCExprContext ctx) {
        append("(");
        visit(ctx.cunitExpr());
        append(")");
        return null;
    }

    @Override public Void visitNotCExpr(CCompilerParser.NotCExprContext ctx) {
        append("not");
        visit(ctx.cunitExpr());
        return null;
    }


    @Override public Void visitCallExpression(CCompilerParser.CallExpressionContext ctx) {
        if(ctx.IDENTIFIER().getText().equals("printf")){
            append("print");
            append("(");
            printing = true;
            visitChildren(ctx);
            append(",end = '')");
        }
        else if(ctx.IDENTIFIER().getText().equals("scanf")){
            printing = false;
            String s = ctx.callParam().valueExpression(1).getText();
            System.out.println(s);
            append(s.substring(1,s.length() - 1) + " = input()");
        }
        else if(ctx.IDENTIFIER().getText().equals("strcmp")){
            printing = false;
            visit(ctx.callParam().valueExpression(0));
            append(" != ");
            visit(ctx.callParam().valueExpression(1));
        }
        else if(ctx.IDENTIFIER().getText().equals("isdigit")){
            printing = false;
            visit(ctx.callParam().valueExpression(0));
            append(".isdigit()");
        }
        else if(ctx.IDENTIFIER().getText().equals("gets")){
            printing = false;
            visitChildren(ctx);
            append(" = input()");
        }
        else if(ctx.IDENTIFIER().getText().equals("strlen")){
            printing = false;
            append("len");
            append("(");
            visitChildren(ctx);
            append(")");
        }
        else{
            printing = false;
            append(ctx.IDENTIFIER().getText());
            append("(");
            visitChildren(ctx);
            append(")");
        }

        return null;
    }

    @Override public Void visitCallParam(CCompilerParser.CallParamContext ctx) {
        List<CCompilerParser.ValueExpressionContext> param = ctx.valueExpression();
        if(printing ){
            visit(param.get(0));
            if(param.size() > 1) {
                append("%(");
                for (int i = 1; i < param.size(); i++) {
                    if (i > 1) {
                        append(", ");
                    }
                    visit(param.get(i));
                }
                append(")");
            }
        }
        else {
            for (int i = 0; i < param.size(); i++) {
                if (i > 0) {
                    append(", ");
                }
                visit(param.get(i));
            }
        }
        return null;
    }
}
