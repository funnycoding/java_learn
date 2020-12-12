package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/9/8 3:10 下午
 */

class Cup {
    Cup(int marker) {
        System.out.println("Cup (" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f (" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        System.out.println("Cups 构造函数");
    }
}


public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Main函数");
        Cups.cup1.f(99);
    }
}
