package arrays;

import java.util.SplittableRandom;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 2:34 下午
 */
// arrays/IceCreamFlavors.java
public class IceCreamFlavors {
    private static SplittableRandom rand = new SplittableRandom(47);
    static final String[] FLAVORS = {"巧克力", "草莓", "摩卡", "Rum Raisin", "Praline Cream", "Mud Pie"};

    // 返回i个随机挑选的冰淇淋口味
    public static String[] flavorSet(int n) {
        System.out.println("本次挑选 " + n + "种口味的冰淇淋");
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("索引超出口味数组的限制！");
        }
        // 用来保存挑选的口味
        String[] result = new String[n];
        // 用来查看口味是否被选中
        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
                System.out.println("本次随机挑选的冰淇淋口味的索引是: " + t);
            } while (picked[t]);
            // 给 result 中的元素进行赋值
            result[i] = FLAVORS[t];
            picked[t] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            ArrayShow.show(flavorSet(3));
        }
    }
}
