package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 5:24 下午
 */
// CurryingAndPartials.java
public class CurryingAndPartials {
    // 未柯里化的函数，有多个入参
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        // 通过一个 Function 来生成 字符串对象
        Function<String, Function<String, String>> sum =
                a -> b -> a + b; //[1] a 的入参是一个函数b。 b 是一个 返回 a+b 的函数

        System.out.println("uncurried:一个拼接2个字符串的普通方法 " + uncurried("HI ", "Ho"));

        Function<String, String> hi = sum.apply("HI "); //[2]
        String ho = hi.apply("Ho");
        System.out.println("sum.apply:" + ho);

        // 部分应用
        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
