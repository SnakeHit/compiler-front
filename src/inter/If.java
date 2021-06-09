package inter;

import symbols.Type;

/**
 * if语句中间代码生成
 * if (expr) stmt
 */
public class If extends Stmt {
    // 两个抽象语法树的结点
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    public void gen(int b, int a) {
        int label = newlabel(); // stmt 的标号
        expr.jumping(0, a);  // 如果为真，执行下一行, 如果为假，跳到a
        emitlabel(label);      // 产生标号
        stmt.gen(label, a);    // 这里是什么意思？
    }
}
