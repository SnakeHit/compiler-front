package inter;

import symbols.Type;

public class Else extends Stmt {

    Expr expr;
    Stmt stmt1, stmt2;

    public Else(Expr x, Stmt s1, Stmt s2) {
        expr = x;
        stmt1 = s1;
        stmt2 = s2;
        if (expr.type != Type.Bool) expr.error("boolean required in if");
    }

    public void gen(int b, int a) {
        int label1 = newlabel();    // label1用于语句stmt1
        int label2 = newlabel();    // label2用于语句stmt2
        expr.jumping(0, label2); // 如果为真控制流穿越到stmt1，为假时跳转到label2
        emitlabel(label1);         // label1的标号
        stmt1.gen(label1, a);      // stmt1的中间代码
        emit("goto L" + a);     // a标记当前语句的代码之后的第一条指令
        emitlabel(label2);
        stmt2.gen(label2, a);      // stmt2的中间代码
    }
}
