package main;

import lexer.Lexer;
import parser.Parser;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/in.c"));
        System.setIn(in);
        File file = new File("src/outtest.txt");
        PrintStream out = new PrintStream(file);
        System.setOut(out);
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
    }
}
