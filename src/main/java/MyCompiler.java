
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

    MyCompiler(PrintStream output) {
        outputFile = output;
    }


    public static void main(String args[]) throws IOException {
        String name;
        Scanner inputName = new Scanner(System.in);
        FileInputStream c;
        PrintStream py;

        System.out.println("Enter the name of the program (without \".c\" extension):");
        name = inputName.nextLine();
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
        return;
    }

    private void append(String s) {
        outputFile.print(s);
    }

    private void appendLine(String s) {
        outputFile.println(indent + s);
    }

    private void beginLine(String s) {
        append(indent + s);
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


}
