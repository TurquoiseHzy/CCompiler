import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;



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
        outputFile.println(indent + s);
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
        append("def " + ctx.)
        return visitChildren(ctx);
    }

    @Override public Void visitFunctionBlock(CCompilerParser.FunctionBlockContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunctionType(CCompilerParser.FunctionTypeContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunctionName(CCompilerParser.FunctionNameContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunctionParams(CCompilerParser.FunctionParamsContext ctx) { return visitChildren(ctx); }

    @Override public Void visitParam(CCompilerParser.ParamContext ctx) { return visitChildren(ctx); }

    @Override public Void visitControlExpression(CCompilerParser.ControlExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitForExpression(CCompilerParser.ForExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitForTitle(CCompilerParser.ForTitleContext ctx) { return visitChildren(ctx); }

    @Override public Void visitBlock(CCompilerParser.BlockContext ctx) { return visitChildren(ctx); }

    @Override public Void visitReturnExpression(CCompilerParser.ReturnExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitWhileExpression(CCompilerParser.WhileExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitWhileTitle(CCompilerParser.WhileTitleContext ctx) { return visitChildren(ctx); }

    @Override public Void visitIfExpression(CCompilerParser.IfExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitIfTitle(CCompilerParser.IfTitleContext ctx) { return visitChildren(ctx); }

    @Override public Void visitElseifTitle(CCompilerParser.ElseifTitleContext ctx) { return visitChildren(ctx); }

    @Override public Void visitDefineExpression(CCompilerParser.DefineExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVariableName(CCompilerParser.VariableNameContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVarDefineWithInit(CCompilerParser.VarDefineWithInitContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVarDefineWithoutInit(CCompilerParser.VarDefineWithoutInitContext ctx) { return visitChildren(ctx); }

    @Override public Void visitArrayDefine(CCompilerParser.ArrayDefineContext ctx) { return visitChildren(ctx); }

    @Override public Void visitAssignExpression(CCompilerParser.AssignExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitValueExpression(CCompilerParser.ValueExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVExpr(CCompilerParser.VExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitCExpr(CCompilerParser.CExprContext ctx) { return visitChildren(ctx); }

    @Override public Void visitCallExpression(CCompilerParser.CallExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Void visitCallParam(CCompilerParser.CallParamContext ctx) { return visitChildren(ctx); }
}
