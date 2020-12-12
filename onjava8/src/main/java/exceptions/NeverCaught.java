package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 7:09 下午
 */

public class NeverCaught {
    static void f() {
        throw new RuntimeException("f() 抛出的 RuntimeException");
    }

    // 调用f并抛出运行时异常
    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
