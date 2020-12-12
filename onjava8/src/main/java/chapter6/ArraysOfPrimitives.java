package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/9/8 3:23 下午
 */

public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] += 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a["+ i + "]:" + a1[i]);
        }
    }
}
