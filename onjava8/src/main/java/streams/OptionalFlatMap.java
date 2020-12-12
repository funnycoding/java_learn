package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 2:58 下午
 */

// OptionalFlatMap.java
// 例子和上个例子一样，只是最后将返回值用 Optional.of() 进行包裹。
public class OptionalFlatMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.println(" ---( " + descr + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .flatMap(func)
            );
        }
    }

    public static void main(String[] args) {
        test("增加括号", s -> Optional.of("[ " + s + " ]"));

        test("加一", s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (Exception e) {
                return Optional.of(s);
            }
        });

        test("替换", s -> Optional.of(s.replace("2", "9")));

        test("获取最后一位", s -> Optional.of(
                s.length() > 0 ? s.charAt(s.length() - 1) + ""
                        : s));
    }
}
