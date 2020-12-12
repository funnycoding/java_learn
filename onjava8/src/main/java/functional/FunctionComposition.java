package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 函数组合
 * @date 2020/2/18 4:57 下午
 */

// FunctionComposition.java
public class FunctionComposition {

    // 这里声明了4个函数 f4 是前三个的组合
    static Function<String, String> f1 = s -> {
        System.out.println("f1获得了原始输入字符串: " + s);
        String replace = s.replace('A', '_');
        System.out.println("f1将字符串中的 A 替换为 _, 替换后的字符串是：" + replace);
        return replace;
    },
            f2 = s -> {
                System.out.println("f2获得了原始输入字符串: " + s);
                String substring = s.substring(3);
                System.out.println("f2将这个字符串截取从第三个字母开始截取，获取其子串: " + substring);
                return substring;
            } ,

    f3 = s -> {
        System.out.println("f3获得了原始输入字符串: " + s +"并将其转为小写");
        return s.toLowerCase();
    },
            // f4 是一个组合函数，先调用 f2 在调用 f1 最后 f3
            f4 = f1.compose(f2).andThen(f3); // compose 表示 f2的调用该发生在f1之前 然后调用 s3

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULAMNCES"));
    }
}
