package inter;

import lexer.Token;
import symbols.Type;

/**
 * 类Arith实现了双目运算符，比如+和*
 * 构造函数Arith首先调用super(tok,null)
 * 其中tok是一个表示该运算符的词法单元，null是该类型的占位符
 */
public class Arith extends Op {

    public Expr expr1, expr2;

    public Arith(Token tok, Expr x1, Expr x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        // 这里确定符号类型
        type = Type.max(expr1.type, expr2.type);
        if (type == null) error("type error");
    }

    public Expr gen() {
        // gen把子表达式规约成地址，假设gen在a+b*c的根部被调用
        // 则expr1.reduce()会导致 t1 = b*c
        // expr2.reduce()会导致 t2 = a
        return new Arith(op, expr1.reduce(), expr2.reduce());
    }

    // 这里才是真正的toString()方法
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
