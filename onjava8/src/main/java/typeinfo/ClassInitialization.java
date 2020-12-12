package typeinfo;

import java.util.Random;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 7:24 下午
 */

// typeinfo/ClassInitialization.java
// 关于类的初始化
class Initable {
    // 打印常量静态字段的时候并没有导致静态代码块的调用
    static final int STATIC_FINAL = 47;
    // 这里虽然是一个静态的final int 值，但是涉及到别的类 rand 字段的初始化 所以打印整个变量的时候 Initable 类被加载
    static final int STATIC_FINAL_2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initable 的静态代码块被调用了");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initable2的静态代码块被调用了");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initable3 的静态代码块被调用了");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过类的字面量来获取 Class 对象并不会导致 Initable 类被加载，静态代码块不会被调换用
        Class initableClass = Initable.class;

        // 使用字面量常量获得 Class 对象并没有触发类的初始化
        System.out.println("通过类字面量获取 Initable Class 对象之后");

        // 打印类的静态常量也不会触发类的加载
        System.out.println("打印 Initable 类的 STATIC_FINAL 字段：" + Initable.STATIC_FINAL);

        // 打印 STATIC_FINAL2 字段，Initable 类被加载
        System.out.println("打印 Initable 类的 STATIC_FINAL2 字段：" + Initable.STATIC_FINAL_2);

        // 打印 Initable2的 静态变量，类被加载
        System.out.println("打印 Initable2 类的 staticNonFinal 字段：" + Initable2.staticNonFinal);

        // 使用 forName 获取类对象，类被加载
        Class initable3 = Class.forName("typeinfo.Initable3");

        System.out.println("After Initializing initbale3 Ref");

        System.out.println(Initable3.staticNonFinal);
    }
}
