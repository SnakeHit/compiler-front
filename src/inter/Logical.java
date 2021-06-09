package inter;

import lexer.Token;
import symbols.Type;

/**
 *  逻辑操作符中间代码生成基类
 *  y = x logic z
 *  作为类Or、And和Not的父类，提取出了基函数
 * */
public class Logical extends Expr {

    public Expr expr1, expr2;
    // 构造出一个抽象语法数结点，其中运算符是tok，运算分量是x1和x2
    // x1 和 x2 都是布尔类型
    Logical(Token tok, Expr x1, Expr x2) {
        super(tok, null);                      // null type to start
        expr1 = x1;
        expr2 = x2;
        type = check(expr1.type, expr2.type); // 保证了一定是布尔类型
        if (type == null) error("type error");
    }

    public Type check(Type p1, Type p2) {
        if (p1 == Type.Bool && p2 == Type.Bool) return Type.Bool;
        else return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Expr gen() {
        int f = newlabel();//
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
