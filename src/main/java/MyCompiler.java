import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class MyCompiler extends CCompilerBaseVisitor<Void>{

    private PrintStream outputFile;
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

        ANTLRInputStream input = new ANTLRInputStream(c);
        CCompilerLexer lexer = new CCompilerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CCompilerParser parser = new CCompilerParser(tokens);
        ParseTree tree = parser.prog();

        MyCompiler compiler = new MyCompiler(py);
        compiler.visit(tree);
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

   // @Override public Void visitProg(CCompilerParser.ProgContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitPreTreatment(CCompilerParser.PreTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitGlobalTreatment(CCompilerParser.GlobalTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitFunctionTreatment(CCompilerParser.FunctionTreatmentContext ctx) { return visitChildren(ctx); }

   // @Override public Void visitFunctionDeclare(CCompilerParser.FunctionDeclareContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunctionDefine(CCompilerParser.FunctionDefineContext ctx) {
        visitChildren(ctx);
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
        appendLine("return ");
        visitChildren(ctx);
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
        append(ctx.getText());
        return null;
    }

    @Override public Void visitVarDefineWithInit(CCompilerParser.VarDefineWithInitContext ctx) {
        append(ctx.IDENTIFIER().getText() + " = ");
        visitChildren(ctx);
        endLine();
        return null;
    }

    //@Override public Void visitVarDefineWithoutInit(CCompilerParser.VarDefineWithoutInitContext ctx) { return visitChildren(ctx); }

    @Override public Void visitArrayDefine(CCompilerParser.ArrayDefineContext ctx) { return visitChildren(ctx); } //to do

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
        endLine(ctx.op.getText());
        return null;
    }

    @Override public Void visitCallAssign(CCompilerParser.CallAssignContext ctx) {
        appendLine("");
        visitChildren(ctx);
        endLine();
        return null;
    }

    @Override public Void visitValueExpression(CCompilerParser.ValueExpressionContext ctx) { return visitChildren(ctx); } //to do

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
                append(ctx.op.getText());
            }
            visit(param.get(i));
        }
        return null;
    }

    @Override public Void visitCunitExpr(CCompilerParser.CunitExprContext ctx) {
        visit(ctx.vExpr(0));
        append(ctx.op.getText());
        visit(ctx.vExpr(1));
        return null;
    }

    @Override public Void visitCallExpression(CCompilerParser.CallExpressionContext ctx) {
        append(ctx.IDENTIFIER().getText() + '(');
        visitChildren(ctx);
        append(")");
        return null;
    }

    @Override public Void visitCallParam(CCompilerParser.CallParamContext ctx) {
        List<CCompilerParser.ValueExpressionContext> param = ctx.valueExpression();
        for(int i = 0 ; i < param.size() ; i ++) {
            if (i > 0) {
                append(", ");
            }
            visit(param.get(i));
        }
        return null;
    }
}
