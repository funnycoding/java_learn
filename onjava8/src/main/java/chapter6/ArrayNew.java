package chapter6;

import java.util.Arrays;
import java.util.Random;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/9/8 3:27 下午
 */

public class ArrayNew {
    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(47);
        // 给数组a随机分配一个20之内的长度
        a = new int[rand.nextInt(20)];
        System.out.println("a 的数组长度：" + a.length);
        // 打印数组元素，可以看到没有初始化的默认intp[] 的初始值是0
        System.out.println(Arrays.toString(a));
    }
}
