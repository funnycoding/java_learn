package chapter5;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/11/16 12:07 下午
 */

public class IfElse {
    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target) {
            result += 1;
        } else if (testval < target) {
            result = -1;
        } else {
            result = 0;
        }
    }

    static void itera() {
        for (; ; ) {
            System.out.println("死循环一下");
        }
    }

    public static void main(String[] args) {
        test(10, 5);
        System.out.println("result value: " + result);
        test(5, 10);
        System.out.println("result value: " + result);
        test(5, 5);
        System.out.println("result value: " + result);

        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " +i + "," + "j = " + j);
        }
    }
}
