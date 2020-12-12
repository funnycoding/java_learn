package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/1 10:42 下午
 */

public class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}