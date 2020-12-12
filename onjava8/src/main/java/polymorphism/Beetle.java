package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/7 10:44 下午
 */

class Insect {
    private int i = 9;
    protected int j;

    /**
     * 基类先被初始化
     */
    public Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    /**
     * 静态变量先被调用
     */
    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    // 类被装载的时候，先初始化类变量，然后调用构造函数
    private int k = printInit("Beetle.k.initialized");
    private int e = printInit("Beetle.e.initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }



    // 子类静态变量第二顺位被初始化
    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        // 输出语句在类被加载后执行
        System.out.println("Beetle constructor");
        // 构造子类对象，先调用父类的构造函数
        Beetle b = new Beetle();
    }
}
