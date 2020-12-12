package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 5:36 下午
 */

// FunctionMap.java
public class FunctionMap {
    static String[] elements = {"12", "", "23", "45"};

    // 将字符串转为字符串流
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    // 遍历 Function
    static void test(String descr, Function<String, String> func) {
        System.out.println("----(" + descr + " )----");
        testStream()
                .map(func)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // 给每个元素增加括号
        test("add brackets", s -> "[" + s + "]");

        // 给所有元素加一，如果元素不是 Int类型则直接返回
        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

        // 将包含2的元素中的2替换为9
        test("Replace", s -> s.replace("2", "9"));


        // 如果字符串长度大于0 返回第一位的元素，否则返回原字符串
        test("Take last digit",
                s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);
    }
}
