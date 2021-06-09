package inter;

/**
 * 表示语句结点生成
 * 这里是语句构造的世界，每一个语句构造都是Stmt的一个子类
 */
public class Stmt extends Node {

    public Stmt() {} // 相关工作在子类中完成

    public static Stmt Null = new Stmt(); // 表示一个空的语句序列

    /**
     * 生成中间代码,
     *
     * @param b 标记当前语句开始
     * @param a 标记当前语句的代码之后的第一条指令
     */
    public void gen(int b, int a) {} //

    int after = 0;                   // saves label after
    public static Stmt Enclosing = Stmt.Null;  // used for break stmts
}
