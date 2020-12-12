package streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 8:26 下午
 */

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
}

public class Matching {
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),
                        n -> n < val
                )
        );
    }

    public static void main(String[] args) {
        show(Stream::allMatch,10);
        show(Stream::allMatch,4);
        show(Stream::anyMatch,2);
        show(Stream::anyMatch,0);
        show(Stream::noneMatch,5);
        show(Stream::noneMatch,0);
    }
}
