package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 6:29 下午
 */

// StreamOfStreams.java

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1,2,3)
                .map( i -> Stream.of("Gonzo","K","B"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}
