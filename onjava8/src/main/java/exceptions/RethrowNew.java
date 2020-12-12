package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 5:40 下午
 */

// RethrowNew.java

class OneException extends Exception {
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception {
    public TwoException(String message) {
        super(message);
    }
}


public class RethrowNew {
    public static void f() throws OneException {
        System.out.println("f()抛出 OneException");
        throw new OneException("来自f()的异常对象");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (OneException e) {
            System.out.println("f()的异常对象被捕获，并打印其栈桢信息");
            e.printStackTrace(System.out);
            System.out.println("抛出新的异常对象 TwoException");
            try {
                throw new TwoException("在 Catch 语句中重新抛出的异常对象 TwoException ");
            } catch (TwoException ex) {
                System.out.println("捕获 Two Exception 异常对象，并打印其栈桢");
                ex.printStackTrace(System.out);
            }
        }
    }

}
