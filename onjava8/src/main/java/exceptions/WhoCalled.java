package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 4:07 下午
 */

// WhoCalled.java

public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
            //
        } catch (Exception e) {
            System.out.println("开始打印f栈桢");
            // 打印栈桢元素
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        System.out.println("我是 g() 我调用了 f()");
        f();
    }

    static void h() {
        g();
        System.out.println("我是 h() 我调用了 g()");
    }

    public static void main(String[] args) {
        System.out.println("-------------- f() --------------");
        f();
        System.out.println("---------------");

        System.out.println("-------------- g() --------------");
        g();
        System.out.println("---------------");

        System.out.println("-------------- h() --------------");
        h();
        System.out.println("---------------");
    }
}
