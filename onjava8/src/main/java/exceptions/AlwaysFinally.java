package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 7:39 下午
 */

// AlwaysFinally.java

class FourException extends Exception {

}

public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("进入第二个 try块");
            try {
                throw new FourException();
            } finally {
                System.out.println("第二个 try 块里的 finally");
            }
        } catch (FourException e) {
            System.out.println("捕获异常的第一个 block");
        }finally {
            System.out.println("第一个 try 块的 finally");
        }
    }
}
