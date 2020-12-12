package streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 6:52 下午
 */

public class StreamOfRandoms {
    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100)
                                .limit(i), IntStream.of(-1)))
                .forEach(n -> System.out.format("%d ", n));
    }
}
