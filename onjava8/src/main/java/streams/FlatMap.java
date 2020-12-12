package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 6:32 下午
 */

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1,2,3)
                .flatMap( i -> Stream.of("G","B","K"))
                .forEach(System.out::println);
    }
}
