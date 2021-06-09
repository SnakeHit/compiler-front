package inter;

import lexer.Token;

/**
 * !是单目运算符，也是逻辑运算的一部分
 */
public class Not extends Logical {

    public Not(Token tok, Expr x2) {
        super(tok, x2, x2);
    }

    // 对调出口
    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}
