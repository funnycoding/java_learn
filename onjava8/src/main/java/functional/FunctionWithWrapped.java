package functional;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:39 下午
 */
// FunctionWithWrapped.java
// 当使用 Function 的时候，涉及到对象的装箱和拆箱，这时候选择使用对应的专门类型可以省略这个步骤，提高效率
public class FunctionWithWrapped {
    public static double returnD(int i) {
        return i;
    }

    public static int returnI(double d) {
        return (int) d;
    }


    public static void main(String[] args) {
        // 这里使用 Function接口的话，实现的时候需要进行显示的类型强转
        Function<Integer, Double> fid = i -> (double) i;
        // 使用专门的转换类就不需要
        IntToDoubleFunction fid2 = i -> i;

        // 这里我加了个 使用 double 转 int的内置函数接口，把 returnI 也用上了
        DoubleToIntFunction d = FunctionWithWrapped::returnI;
        double v = returnD(10);
    }
}
