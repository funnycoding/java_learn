package generics;

import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import onjava.Rand;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 8:18 下午
 */
// Fill an array using a generator:
// generics/PrimitiveGenericTest.java
interface FillArray {
    static <T> T[] fill(T[] a, Supplier<T> gen) {
        Arrays.setAll(a, n -> gen.get());
        return a;
    }

    static int[] fill(int[] a, IntSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsInt());
        return a;
    }

    static long[] fill(long[] a, LongSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsLong());
        return a;
    }

    static double[] fill(double[] a, DoubleSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsDouble());
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        // 这里我把 Rand.String 改为 StringGen了，不然老解决包的冲突很烦人
        String[] strings = FillArray.fill(new String[5], new Rand.StringGen(9));
        System.out.println(Arrays.toString(strings));

        int[] integers = FillArray.fill(new int[9], new Rand.Pint());
        System.out.println(Arrays.toString(integers));
    }

}
