package inter;

import lexer.Lexer;

/**
 * 语义结点基类
 * */
public class Node {
    // 保存了本结点对应的构造在源程序中的行号
    int lexline = 0;

    Node() {
        lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    // 全局变量，保存当前已经生成了labels的数量
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
