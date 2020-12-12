package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:54 下午
 */
// functional/Closure3.java
public class Closure3 {
    IntSupplier makeFun(int x) {
       final int i = 0;
        //
        return () -> x + i;
    }
}
