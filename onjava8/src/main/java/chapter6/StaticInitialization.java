package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/9/8 2:40 下午
 */

class Bowl {
    public Bowl(int maker) {
        System.out.println("Bowl(" + maker + ")");
    }

    void f1(int maker) {
        System.out.println("f1(" + maker + ")");
    }
}

class Table {
    // 静态变量，初始化了一个 bowl对象
    static Bowl bowl1 = new Bowl(1);

    public Table() {
        System.out.println("Table");
        bowl2.f1(1);
    }

    void f2(int maker) {
        System.out.println("f2(" + maker + ")");
    }

    // 定义了第二个静态类比那辆
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    // 定义了普通成员变量和静态类变量
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        System.out.println("Cupboard");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    // 定义了第二个静态类变量
    static Bowl bowl5 = new Bowl(5);
}

/**
 * 我猜测的运行顺序：
 * 1. 类静态变量在类被加载时就初始化，因此 StaticInitialization 中的 Table 和 Cupboard 最先被初始化
 * 2. Table 被初始化时 其类中的 Bowl 被初始化
 *
 * 输出：
 * Bowl(1）
 * Bowl(2)
 * 以上两条来自加载 Table 时初始化其中的 静态成员变量
 * Table —— 来自 Table 类构造函数
 * f1(1) —— Table 构造函数中调用的 bowl2 的 f1(1) 函数
 *  Bowl(4）
 *  Bowl(5)
 *  Bowl(3) —— 初始化类成员变量（这个执勤啊漏掉了）
 *  以上两条来自加载 Cupboard 时初始化其中的 静态成员变量
 *  Cupboard —— 构造函数
 *  f1(2) —— 构造函数中调用 bowl f1 函数，入参是2
 *
 *  此时静态成员初始化完毕，开始执行 main 函数
 *  Main 中，创建 CupBoard之前
 *  Bowl(3) —— 成员变量初始化 （漏掉）
 *   Cupboard —— 构造函数
 *   f1(2) —— 构造函数中调用 bowl f1 函数，入参是2
 *   ↑ main 函数中的 Cupboard 对象创建，此时不需要再初始化静态变量，只执行构造函数
 *   Main 中，创建 CupBoard之后
 *   即将创建第二个 Cupboard
 *   Bowl(3) —— 成员变量初始化 （漏掉）
 *   Cupboard —— 构造函数
 *   f1(2) —— 构造函数中调用 bowl f1 函数，入参是2
 *   ↑ main 函数中的第二个 Cupboard 对象创建，此时不需要再初始化静态变量，只执行构造函数
 *   第二个 Cupboard 创建完成
 *   即将调用 StaticInitialization 的静态成员 TAble 的f2 方法
 *   f2(1) —— table 对象的 f2函数被调用
 *   f3(1) —— cupboard 的 f3函数被调用
 *
 *
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Main 中，创建 CupBoard之前");
        new Cupboard();
        System.out.println("Main 中，创建 CupBoard之后");
        System.out.println("即将创建第二个 Cupboard");
        new Cupboard();
        System.out.println("第二个 Cupboard 创建完成");
        System.out.println("即将调用 StaticInitialization 的静态成员 TAble 的f2 方法");
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
