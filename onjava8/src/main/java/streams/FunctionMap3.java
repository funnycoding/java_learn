package streams;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 6:12 下午
 */

// FunctionMap3.java
public class FunctionMap3 {
    public static void main(String[] args) {
        Stream.of("5","7","9")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ",n));

        System.out.println();
        Stream.of("17", "19", "23")
                .mapToLong(Long::parseLong)
                .forEach(n -> System.out.format("%d ", n));

        System.out.println();
        Stream.of("17", "1.9", ".23")
                .mapToDouble(Double::parseDouble)
                .forEach(n -> System.out.format("%f ", n));
    }
}
