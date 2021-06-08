package symbols;

import inter.Id;
import lexer.Token;

import java.util.Hashtable;
// 符号表
public class Env {

    // 使用 hash 表存储
    private Hashtable table;
    protected Env prev;

    public Env(Env n) {
        table = new Hashtable();
        prev = n; // 指向上一层符号表
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    public Id get(Token w) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = (Id) (e.table.get(w));
            if (found != null) return found;
        }
        return null;
    }
}
