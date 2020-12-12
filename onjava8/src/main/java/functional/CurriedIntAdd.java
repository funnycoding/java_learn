package functional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 9:34 下午
 */

public class CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> curriedIntAdd = a -> b -> a + b;

        IntUnaryOperator add4 = curriedIntAdd.apply(4);
        System.out.println(add4);
        System.out.println(add4.applyAsInt(5));
    }
}
