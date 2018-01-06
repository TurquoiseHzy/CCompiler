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

        name = "hello";
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
    private Set<String> local_var_set  = null;
    private Set<String> global_var_set = null;

    private void var_def(String varname){
        if(inFunc){
            if((var_check(varname) & 1) != 0){
                throw new VariableException("variable "+ varname +" redefined!");
            }
            local_var_set.add(varname);
        }
        else{
            if((var_check(varname) & 3) != 0){
                throw new VariableException("variable "+ varname +" redefined!");
            }
            global_var_set.add(varname);
        }
    }

    private int var_check(String varname){
        int res = 0;
        if(local_var_set.contains(varname)) {
            res |= 1;
        }
        if(global_var_set.contains(varname)){
            res |= 2;
        }
        return res;
    }


    private void set_local_init(){
        if (local_var_set == null) {
            local_var_set = new HashSet();
        }
        local_var_set.clear();
    }


    private void set_global_init(){
        if (global_var_set == null) {
            global_var_set = new HashSet();
        }
        global_var_set.clear();
    }


     @Override public Void visitProg(CCompilerParser.ProgContext ctx){
         set_global_init();
        return visitChildren(ctx);
    }

   // @Override public Void visitPreTreatment(CCompilerParser.PreTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitGlobalTreatment(CCompilerParser.GlobalTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitFunctionTreatment(CCompilerParser.FunctionTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitFunctionDeclare(CCompilerParser.FunctionDeclareContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunctionDefine(CCompilerParser.FunctionDefineContext ctx) {
        set_local_init();
        if(ctx.functionTitle().functionName().getText().equals("main")){
            inMain = true;
        }
        else{
            inMain = false;
        }
        inFunc = true;
        visitChildren(ctx);
        inFunc = false;
        indent = "";
        return null;
    }

    @Override public Void visitFunctionTitle(CCompilerParser.FunctionTitleContext ctx) {
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


    // @Override public Void visitFunctionType(CCompilerParser.FunctionTypeContext ctx) { return visitChildren(ctx); }

    // @Override public Void visitFunctionName(CCompilerParser.FunctionNameContext ctx) { return visitChildren(ctx); }

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
        var_def(ctx.IDENTIFIER().getText());
        append(ctx.IDENTIFIER().getText());
        return null;
    }

    @Override public Void visitControlExpression(CCompilerParser.ControlExpressionContext ctx) {
        appendLine("");
        return visitChildren(ctx);
    }

    @Override public Void visitForExpression(CCompilerParser.ForExpressionContext ctx) { return visitChildren(ctx); } // to do

    @Override public Void visitForTitle(CCompilerParser.ForTitleContext ctx) { return visitChildren(ctx); }

    @Override public Void visitBlock(CCompilerParser.BlockContext ctx) {
        incIndent();
        visitChildren(ctx);
        decIndent();
        return null;
    }

    @Override public Void visitReturnExpression(CCompilerParser.ReturnExpressionContext ctx) {
        appendLine("return");
        if(inMain == false) {
            append(" ");
            visitChildren(ctx);
        }
        endLine();
        return null;
    }

    // @Override public Void visitWhileExpression(CCompilerParser.WhileExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitWhileTitle(CCompilerParser.WhileTitleContext ctx) {
        append("while ");
        visitChildren(ctx);
        endLine(":");
        return  null;
    }

    //@Override public Void visitIfExpression(CCompilerParser.IfExpressionContext ctx) { return visitChildren(ctx); }

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
        appendLine("");
        return visitChildren(ctx);
    }

    @Override public Void visitVariableName(CCompilerParser.VariableNameContext ctx) {
        if(var_check(ctx.IDENTIFIER().getText()) == 0) {
            throw new VariableException("variable "+ ctx.IDENTIFIER().getText() +" undefined!");
        };

        append(ctx.getText());
        return null;
    }

    @Override public Void visitVarDefineWithInit(CCompilerParser.VarDefineWithInitContext ctx) {
        var_def(ctx.IDENTIFIER().getText());
        append(ctx.IDENTIFIER().getText() + " = ");
        visitChildren(ctx);
        endLine();
        return null;
    }

    @Override public Void visitVarDefineWithoutInit(CCompilerParser.VarDefineWithoutInitContext ctx) {
        var_def(ctx.IDENTIFIER().getText());
        append(ctx.IDENTIFIER().getText() + " = None");
        endLine();
        return null;
    }

    @Override public Void visitArrayDefine(CCompilerParser.ArrayDefineContext ctx) {
        var_def(ctx.IDENTIFIER().getText());
        if(ctx.TYPE().getText().equals("char")){

            append(ctx.IDENTIFIER().getText() + " = \"" +( (ctx.STRING() != null) ? ctx.STRING() : "") + "\"");
        }
        else if (ctx.list() == null){
            append(ctx.IDENTIFIER().getText() + " = [0]*" + ctx.CONSTANT().getText());
        }
        else{
            append(ctx.IDENTIFIER().getText() + " = ");
            visit(ctx.list());
        }

        endLine();
        return null;
    } //to do

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

    @Override public Void visitBinaryAssign(CCompilerParser.BinaryAssignContext ctx) {
        appendLine("");
        visit(ctx.variableName());
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

    @Override public Void visitConstVExpr(CCompilerParser.ConstVExprContext ctx) {
        append(ctx.getText());
        return null;
    }

    @Override public Void visitBinaryVExpr(CCompilerParser.BinaryVExprContext ctx) {
        visit(ctx.vExpr(0));
        append(ctx.op.getText());
        visit(ctx.vExpr(1));
        return null;
    }

    @Override public Void visitCallVExpr(CCompilerParser.CallVExprContext ctx) { return visitChildren(ctx); }

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

    @Override public Void visitCunitExpr(CCompilerParser.CunitExprContext ctx) {
        visit(ctx.vExpr(0));
        append(" " + ctx.op.getText() + " ");
        visit(ctx.vExpr(1));
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
            append(ctx.callParam().valueExpression(1).getText() + " = input()");
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
        if(printing == true){
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
