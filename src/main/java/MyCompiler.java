import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//import org.antlr.v4.runtime.tree.TerminalNode;

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
        //name = inputName.nextLine();
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

    @Override public Void visitProg(CCompilerParser.ProgContext ctx) { return visitChildren(ctx); }

    @Override public Void visitPretreatment(CCompilerParser.PretreatmentContext ctx) { return visitChildren(ctx); }

    @Override public Void visitPresentence(CCompilerParser.PresentenceContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunc_def(CCompilerParser.Func_defContext ctx) {
        append("def " + ctx.func_name().getText() + "(");
        visit(ctx.func_param());
        appendLine("):");
        visit(ctx.func_block());
        return null;
    }

    @Override public Void visitFunc_block(CCompilerParser.Func_blockContext ctx) {
        incIndent();
        visitChildren(ctx);
        decIndent();
        return null;
    }

    @Override public Void visitStatement(CCompilerParser.StatementContext ctx) { return visitChildren(ctx); }

    @Override public Void visitRet(CCompilerParser.RetContext ctx) { return visitChildren(ctx); }

    @Override public Void visitReturn_val(CCompilerParser.Return_valContext ctx) { return visitChildren(ctx); }

    @Override public Void visitDeclaration(CCompilerParser.DeclarationContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunc_declaration(CCompilerParser.Func_declarationContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunc_type(CCompilerParser.Func_typeContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunc_name(CCompilerParser.Func_nameContext ctx) { return visitChildren(ctx); }

    @Override public Void visitFunc_param(CCompilerParser.Func_paramContext ctx) {
        List<CCompilerParser.Param_typeContext> params_type = ctx.param_type();
        List<CCompilerParser.Param_nameContext> params_name = ctx.param_name();
        for(int i = 0 ; i < params_type.size() ; i ++){
            if( i > 0 ){
                append(",");
            }
            append(params_type.get(i).getText()+ " " + params_name.get(i).getText() );
        }
        return null;
    }

    @Override public Void visitParam_type(CCompilerParser.Param_typeContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Void visitParam_name(CCompilerParser.Param_nameContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Void visitVar_declaration(CCompilerParser.Var_declarationContext ctx) {
        appendLine(ctx.var_type().getText() + " " + ctx.var_name().getText());
        return visitChildren(ctx);
    }

    @Override public Void visitVar_type(CCompilerParser.Var_typeContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVar_name(CCompilerParser.Var_nameContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVar_value_int(CCompilerParser.Var_value_intContext ctx) { return visitChildren(ctx); }

    @Override public Void visitVar_value_char(CCompilerParser.Var_value_charContext ctx) { return visitChildren(ctx); }
}
