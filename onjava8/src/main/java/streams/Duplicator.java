package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 1:54 下午
 */
// Duplicator.java
public class Duplicator {
    public static void main(String[] args) {

        Stream.generate(()->"duplicate")
                .limit(10)
                .forEach(System.out::println);
    }
}
