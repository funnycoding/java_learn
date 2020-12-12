package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/29 3:28 下午
 */
// generics/GenericVarargs.java
public class GenericVarags {


    @SafeVarargs
    public static <T> List<T> makeList(T... args) { // 可以传入数量不定的参数
        ArrayList<T> result = new ArrayList<>();

        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList(
                "ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);

        // 个人添加
        List<Object> mixUp = makeList("A", 1, 1.0, new GenericVarags());
        System.out.println(mixUp);
    }
}
