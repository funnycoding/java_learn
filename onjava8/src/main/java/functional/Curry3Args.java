package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 9:26 下午
 */
// functional/Curry3Args.java
public class Curry3Args {
    public static void main(String[] args) {
        // 对三个字符串进行拼接 进行 Function嵌套
        Function<String, Function<String, Function<String, String>>> sum = a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> hi = sum.apply("Hi ");
        Function<String, String> ho = hi.apply("Ho ");
        String hup = ho.apply("Hup");
        System.out.println(hup);
    }
}
