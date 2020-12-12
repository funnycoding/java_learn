package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 7:15 下午
 */

// FinallyWorks.java
class ThreeException extends Exception {
}


public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
            if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("没有发生异常");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("finnaly 方法块中的代码被执行");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}
