package inter;

import lexer.Tag;
import lexer.Word;
import symbols.Type;

/**
 * 数组中间代码生成
 * y = a[x]
 * */
public class Access extends Op {

    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p) {    // p is element type after
        super(new Word("[]", Tag.INDEX), p);  // flattening the array
        array = a;
        index = i;
    }

    /**
     * 数组下标可以是表达式或直接标量
     * */
    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    /**
     *
     * */
    @Override
    public void jumping(int t, int f) {
        emitJumps(reduce().toString(), t, f);
    }

    @Override
    public String toString() {
        return array.toString() + " [ " + index.toString() + " ]";
    }
}
