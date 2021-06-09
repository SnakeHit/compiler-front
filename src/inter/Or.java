package inter;

import lexer.Token;

/**
 * 继承自Logical父类
 */
public class Or extends Logical {

    public Or(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    // 方法jumping生成了一个布尔表达式B = B1 || B2的跳转代码
    // 当前假设 B 的true出口 t 和false的出口 f 都不是特殊标号0（如果为0代表没有）
    // 如果 B1 为真，B 一定为真，所以B1的出口必然是t，而false出口对应于B2的第一条指令
    // B2的 true 和 false 出口和B的相应出口相同
    public void jumping(int t, int f) {
        int label = t != 0 ? t : newlabel();
        expr1.jumping(label, 0); // B1
        expr2.jumping(t, f); // B2
        if (t == 0) emitlabel(label); // 如果生成了新标号的话，就在最后生成
    }
}
