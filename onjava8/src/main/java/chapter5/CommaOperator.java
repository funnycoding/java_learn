package chapter5;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/11/16 12:30 下午
 */

public class CommaOperator {
    public static void main(String[] args) {
        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
}
