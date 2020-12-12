package generics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 7:55 下午
 */
// generics/ListOfInt.java
// Autoboxing compensates for the inability
// to use primitives in generics
// 通过 IntStream 生成一个整数流 然后通过 Boxed 转为 Stream<Integer>
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = IntStream.range(38, 48)
                .boxed()
                .collect(Collectors.toList());
        System.out.print(li);
    }
}
