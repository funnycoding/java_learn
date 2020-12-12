package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 3:39 下午
 */
// RandomList.java
public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);

    // 随机获取一个元素
    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream("The quick brown fox jumped over the lazy brown dog".split(" ")).forEach(rs::add);
        IntStream.range(0, 11)
                .forEach(i -> System.out.print(rs.select() + " "));
    }
}
