package inter;

import lexer.Num;
import lexer.Token;
import lexer.Word;
import symbols.Type;

/**
 * 在抽象语法树中构造出一个标号为tok、类型为p的叶子结点
 */
public class Constant extends Expr {

    public Constant(Token tok, Type p) {
        super(tok, p);
    }

    // 根据整数创建一个常量对象
    public Constant(int i) {
        super(new Num(i), Type.Int);
    }

    public static final Constant
            True = new Constant(Word.True, Type.Bool),
            False = new Constant(Word.False, Type.Bool);

    public void jumping(int t, int f) {
        if (this == True && t != 0) emit("goto L" + t);
        else if (this == False && f != 0) emit("goto L" + f);
    }
}
