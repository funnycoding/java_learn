package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:02 下午
 */

public class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;

        return () -> x + i;
    }
}
