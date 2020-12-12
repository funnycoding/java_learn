package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 4:19 下午
 */
// Rethrowing.java
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("我是 ： f() 抛出的异常");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("g 捕获了 f() 抛出的异常，打印其异常栈桢信息: ");
            e.printStackTrace(System.out);
            System.out.println("栈桢打印完毕，g() 重新抛出 f() 的异常");
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("h 捕获了 f() 抛出的异常，打印其异常栈桢信息: ");
            e.printStackTrace(System.out);
            System.out.println("栈桢打印完毕，h重新装填 f()异常 的栈桢信息");

            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("Main方法打印 g() 的栈桢");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            System.out.println("Main方法打印 H(） 的栈桢信息");
            e.printStackTrace(System.out);
        }
    }
}
