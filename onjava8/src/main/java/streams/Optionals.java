package streams;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 11:56 上午
 */

// Optionals.java
public class Optionals {
    static void basics(Optional<String> optString) {

        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("啥也没有");
        }
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(optString.orElseGet(() -> "Generated"));
    }

    static  void OrElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(() -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught" + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === " );
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::OrElseThrow);
    }
}
