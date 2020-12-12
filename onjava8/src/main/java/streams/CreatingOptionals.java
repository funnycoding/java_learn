package streams;

import java.util.Optional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 12:41 下午
 */
// CreatingOptionals.java
public class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        test("empty",Optional.empty());
        test("of", Optional.of("Howdy"));
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        test("ofNullAlbe", Optional.ofNullable("Hi"));
        test("ofNullAlbe", Optional.ofNullable(null));
    }
}
