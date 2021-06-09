package inter;

import lexer.Token;
import symbols.Type;

/**
 * 操作符 x = y op z
 */
public class Op extends Expr {

    /**
     * @param tok 操作符
     * @param p   操作类型
     */
    public Op(Token tok, Type p) {
        super(tok, p);
    }

    /**
     * 生成当前表达式为三地址码右部项赋给临时变量，输出相关的中间代码，返回临时变量
     */
    @Override
    public Expr reduce() {
        // 这里是多态使用，x一般是子类对象
        // 规约为地址
        Expr x = gen();
        Temp t = new Temp(type);
        // 调用子类的toString方法
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
