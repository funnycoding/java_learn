package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 2:43 下午
 */

// InheritingExceptions.java

class SimpleException extends Exception { }


public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("抛出简单异常");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.err.println("抓住你了: " + e.getClass().getSimpleName());
        }
    }
}
