package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 4:58 下午
 */
// CompType.java
public class CompType implements Comparable<CompType> {
    private static int count = 1;
    private static SplittableRandom r = new SplittableRandom(47);
    int i;
    int j;

    // 构造函数
    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // 随机构造 CompType
    public static CompType get() {
        return new CompType(r.nextInt(100), r.nextInt(100));
    }


    @Override
    public String toString() {
        String result = "[i = " + i + "," + "j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return Integer.compare(i, rv.i);
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> get());
        show("排序前 ComType数组：", a);
        Arrays.sort(a);
        show("排序后 ComType数组：", a);
    }
}
