package functional;

import java.util.function.BiConsumer;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:25 下午
 */

// BiConsumerPermutations.java
// 分别输出 int,double / double ,int / int /long
public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicid = (i, d)
            -> System.out.format("%d,%f %n", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i)
            -> System.out.format("%d,%f %n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) ->
            System.out.format("%d,%d %n", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.45, 92);
        bicil.accept(1, 11l);
    }
}
