package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 2:52 下午
 */

// FullCOnstrctors.java

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}


public class FullCOnstrctors {
    public static void f() throws MyException {
        System.out.println("抛出 MyException 。");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("抛出带参数的 MyException from g()");
        throw new MyException("带参数的 Exception 来自 g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
