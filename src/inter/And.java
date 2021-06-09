package inter;

import lexer.Token;

/**
 * 这里是and逻辑运算符，必须满足B1和B2都为真，才为真
 */
public class And extends Logical {

    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public void jumping(int t, int f) {
        int label = f != 0 ? f : newlabel();
        expr1.jumping(0, label); // 如果B1为真，不跳转，进入B2判断。如果为假，无需判断B2
        expr2.jumping(t, f); // B2的出口与B的出口一致
        if (f == 0) emitlabel(label); // 如果产生了新的标号就在最后加上
    }
}
