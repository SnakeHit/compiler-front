package inter;

import lexer.Word;
import symbols.Type;

public class Id extends Expr {
    // 相对地址 relative address
    public int offset;

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }

//	public String toString() {return "" + op.toString() + offset;}
}
