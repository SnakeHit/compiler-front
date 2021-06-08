package inter;

import lexer.Lexer;

/**
 * 语义结点基类
 * */
public class Node {

    int lexline = 0;

    Node() {
        lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    static int labels = 0;

    /**
     * 生成新的Lable
     * */
    public int newlabel() {
        return ++labels;
    }

    /**
     * 输出lable
     * */
    public void emitlabel(int i) {
        System.out.print("L" + i + ":");
    }

    /**
     * 根据参数输出
     * */
    public void emit(String s) {
        System.out.println("\t" + s);
    }
}
