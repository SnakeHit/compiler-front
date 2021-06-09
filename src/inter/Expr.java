package inter;

import lexer.Token;
import symbols.Type;

/**
 * 表达式生成抽象基类
 */
public class Expr extends Node {

    public Token op;
    public Type type;

    Expr(Token tok, Type p) {
        op = tok;
        type = p;
    }

    /**
     * 返回一个项，该项可以成为三地址指令的右部
     * E = E1 + E2  方法gen返回x1 + x2, x1和x2分别存放E1和E2值的地址
     */
    public Expr gen() {
        return this;
    }

    /**
     * 表达式归约为单一地址
     * 返回一个常量，一个标识符，或都一个临时的名称
     * 给定一个表达式E, 返回一个存放E的值临时变量
     */
    public Expr reduce() {
        return this;
    }

    /**
     * 根据true或false标号生成跳转指令
     *
     * @param t 表示true的label标号
     * @param f 表示false的标号
     */
    public void jumping(int t, int f) {
        emitJumps(toString(), t, f);
    }

    /**
     * 根据测试表达式和true与false标号生成跳转指令
     *
     * @param test 测试表达式
     * @param t    表示true的label标号
     * @param f    表示false的标号
     */
    public void emitJumps(String test, int t, int f) {
        // true和false都有标号
        if (t != 0 && f != 0) {
            // 生成如果if test goto L和 goto L
            emit("if " + test + " goto L" + t);
            emit("goto L" + f);
        } else if (t != 0) {
            // t != 0 && f == 0   生成 if test goto L
            emit("if " + test + " goto L" + t);
        } else if (f != 0) {
            // t == 0 && f != 0  生成 iffalse test goto L
            emit("iffalse " + test + " goto L" + f);
        }
        // nothing since both t and f fall through
    }

    // 子类都重写了toString方法
    public String toString() {
        return op.toString();
    }
}
