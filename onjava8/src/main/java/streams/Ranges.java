package streams;

import java.util.stream.IntStream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 10:44 下午
 */

// Ranges.java
public class Ranges {
    public static void main(String[] args) {
        // 传统方法生成整数序列
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);

        // for-in  遍历流生成的数组
        result = 0;
        for (int i : IntStream.range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);

        // 使用流直接进行计算
        System.out.println(IntStream.range(10,20).sum());
    }
}
