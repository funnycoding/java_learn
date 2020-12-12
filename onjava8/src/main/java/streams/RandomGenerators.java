package streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 8:48 下午
 */
// RandomGenerators.java
public class RandomGenerators {
    // 打印流中前4个元素
    public static <T> void show(Stream<T> stream) {
        stream.limit(4)
                .forEach(System.out::println);
        System.out.println("------------");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());
        // 增加上下限范围限制
        show(rand.ints(10,20).boxed());
        show(rand.longs(50,100).boxed());
        show(rand.doubles(20,30).boxed());

        // 控制流大小：
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());

        // 控制流的大小和界限
        show(rand.ints(3, 3, 9).boxed());
        show(rand.longs(3, 12, 22).boxed());
        show(rand.doubles(3, 11.5, 12.3).boxed());
    }
}
