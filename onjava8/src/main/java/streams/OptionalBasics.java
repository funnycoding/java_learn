package streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 11:46 上午
 */

// OptionalBasics.java
// Optional的两个基本用法
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
