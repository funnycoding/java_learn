package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 9:35 下午
 */

// MultiReturns.java

public class MultiReturns {
    public static void f(int i) {
        System.out.println("初始化需要被清理的");
        try {
            System.out.println("Point1");
            if (i == 1) {
                return;
            }
            System.out.println("Point2");
            if (i == 2) {
                return;
            }
            System.out.println("Point3");
            if (i == 3) {
                return;
            }
        } finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            f(i);

        }
    }
}
