package functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 5:09 下午
 */
// PredicateComposition.java
public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3); // 组合函数来了

    public static void main(String[] args) {
        Stream.of("bar","foobar","foobaz","ssar","fongopuckey","foongopuckey")
                .filter(p4)
                .forEach(System.out::println);
    }

}
