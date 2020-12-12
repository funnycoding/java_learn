package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:49 下午
 */

public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        //i++;  // 编译异常 非等同final效果
        // x++;// 同上
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
