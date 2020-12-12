package arrays;

import static onjava.ArrayShow.show;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import onjava.Count;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/8 11:10 下午
 */
// 不太理解这个例子是要干啥的
public class TestCount {
    static final int SZ = 5;

    public static void main(String[] args) {
        System.out.println("Test Boolean");
        Boolean[] a1 = new Boolean[SZ];

        Arrays.setAll(a1, new Count.Boolean()::get);
        show(a1);

        a1 = Stream.generate(new Count.Boolean())
                .limit(SZ + 1)
                .toArray(Boolean[]::new); // 这块看不懂
        show(a1);

        a1 = new Count.Boolean().array(SZ + 2);
        show(a1);

        boolean[] a1b = new Count.Pboolean().array(SZ + 3);
        show(a1b);

        System.out.println("Byte");

        Byte[] a2 = new Byte[SZ];
        Arrays.setAll(a2,new Count.Byte()::get);
        show(a2);

        IntFunction<Byte[]> aNew = Byte[]::new;
        a2 = Stream.generate(new Count.Byte())
                .limit(SZ + 1)
                .toArray(aNew);
        show(a2);
        a2 = new Count.Byte().array(SZ + 2);
    }
}
