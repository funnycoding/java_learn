package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:08 下午
 */

public class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
         int iFInal = i;
         int xFInal = x;
        return () -> iFInal + xFInal;
    }
}
