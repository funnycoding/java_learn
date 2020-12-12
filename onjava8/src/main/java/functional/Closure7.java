package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:14 下午
 */

public class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
        //i = i + 1; // Integer 的值不能改变
        return () -> x + i;
    }
}
