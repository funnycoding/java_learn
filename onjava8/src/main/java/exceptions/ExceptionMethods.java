package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 3:52 下午
 */

// ExceptionMethods.java

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("Get Message : " + e.getMessage());
            System.out.println("getLOcalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("to String() " + e);
            System.out.println("打印堆栈信息: ");
            e.printStackTrace(System.out);
        }
    }
}
