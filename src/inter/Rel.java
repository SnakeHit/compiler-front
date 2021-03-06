package inter;

import lexer.Token;
import symbols.Array;
import symbols.Type;

/**
 * 类Rel实现了运算符<,<=,==,!=,>=,>。函数check检查两个运算分量是否具有相同的类型
 */
public class Rel extends Logical {

    public Rel(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public Type check(Type p1, Type p2) {
        // 不能是数组类型
        if (p1 instanceof Array || p2 instanceof Array) return null;
        else if (p1 == p2) return Type.Bool;
        else return null;
    }

    public void jumping(int t, int f) {
        Expr a = expr1.reduce();
        Expr b = expr2.reduce();
        String test = a.toString() + " " + op.toString() + " " + b.toString();
        emitJumps(test, t, f);
    }
}
