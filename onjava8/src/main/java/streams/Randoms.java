package streams;

import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @descriptionq
 * @date 2020/2/20 5:08 下午
 */
// streams/Randoms.java
public class Randoms {
    public static void main(String[] args) {
        // 创建随机数，给个种子
        new Random(47)
                .ints(5, 20) // 生成  (5,20)的随机数
                .distinct() // 去重
                .limit(7) // 限制数量 7个
                .sorted() // 排序
                .forEach(System.out::println);  // 输出

    }
}
