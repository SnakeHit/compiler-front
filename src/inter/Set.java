package inter;

import symbols.Type;

/**
 * 赋值语句的抽象语法树
 *      =
 *    /  \
 *   /   \
 *  id   expr
 */
public class Set extends Stmt {

    public Id id;       // 标识符
    public Expr expr;   // 表达式

    public Set(Id i, Expr x) {
        id = i;
        expr = x;
        if (check(id.type, expr.type) == null) error("type error");
    }

    // 类型检查
    public Type check(Type p1, Type p2) {
        if (Type.numeric(p1) && Type.numeric(p2)) return p2;
        else if (p1 == Type.Bool && p2 == Type.Bool) return p2;
        else return null;
    }

    // 生成三地址代码
    public void gen(int b, int a) {
        emit(id.toString() + " = " + expr.gen().toString());
    }
}
