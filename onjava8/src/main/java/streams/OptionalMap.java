package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 2:43 下午
 */

// OptionalMap.java
public class OptionalMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.println(" ---( " + descr + " )--- ");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst() // 生成一个Optional对象
                            .map(func)
            );
        }
    }

    public static void main(String[] args) {
        // 如果 Optional 不为空， map() 首先提取
        // the contents which it then passes
        // to the function:
        test("Add brackets", s -> "[" + s + "]");
        test("Increment", s ->{
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });
        test("Replace", s -> s.replace("2", "9"));
        test("Take last dighit", s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);
        // function 执行完毕后，map() 方法将返回结果包装为 Optional对象
    }
}
