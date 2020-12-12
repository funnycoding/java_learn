package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 6:55 下午
 */

// StreamOf.java
public class StreamOf {
    public static void main(String[] args) {

        // 这里有三个将传入元素转为流的例子
        Stream.of(new Bubble(1),
                new Bubble(2),
                new Bubble(3))
                .forEach(System.out::println);

        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie! ")
                .forEach(System.out::print);

        System.out.println();

        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }
}
