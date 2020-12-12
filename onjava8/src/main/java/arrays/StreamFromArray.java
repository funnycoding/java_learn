package arrays;

import java.util.Arrays;
import onjava.ConvertTo;
import onjava.Rand;
import onjava.Rand.Pfloat;
import onjava.Rand.StringGen;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 4:37 下午
 */
// StreamFromArray.java
public class StreamFromArray {
    public static void main(String[] args) {
        String[] s = new StringGen().array(10);

        Arrays.stream(s)
                .skip(3)
                .limit(5)
                .map(ss -> ss + "!")
                .forEach(System.out::println);

        int[] ia = new Rand.Pint().array(10);

        Arrays.stream(ia).skip(3).limit(5)
                .map(i -> i * 10).forEach(System.out::println);

        Arrays.stream(new long[10]);
        Arrays.stream(new double[10]);

        // 只有 int、long、double 可以正常工作
        // - Arrays.stream(new boolean[10]);
        // - Arrays.stream(new byte[10]);
        // - Arrays.stream(new char[10]);
        // - Arrays.stream(new short[10]);
        // - Arrays.stream(new float[10]);
        // 上面的都没有支持
        // For the other types you must use wrapped arrays:
        // 对于其他的基础类型必须使用包装类来创建流
        float[] fa = new Pfloat().array(10);
        Arrays.stream(ConvertTo.boxed(fa)); // 基本类型转包装类
        Arrays.stream(new Rand.Float().array(10));
    }
}
