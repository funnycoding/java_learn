package arrays;

import java.util.Arrays;
import onjava.Count;
import onjava.Rand.StringGen;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 4:04 下午
 */

// ComparingArrays.java
public class ComparingArrays {
    public static final int SZ = 15;

    // 初始化二维数组
    static String[][] twoDArray() {
        String[][] md = new String[5][];
        Arrays.setAll(md, n -> new String[n]);
        for (int i = 0; i < md.length; i++) {
            Arrays.setAll(md[i], new StringGen()::get);
        }
        return md;
    }

    public static void main(String[] args) {
        // 初始化两个 int[] a1,a2
        int[] a1 = new int[SZ], a2 = new int[SZ];

        // 分别填充两个数组
        Arrays.setAll(a1, new Count.Integer()::get);
        Arrays.setAll(a2, new Count.Integer()::get);

        // 判断 a1 a2 是否相等
        System.out.println("a1 == a2: " + Arrays.equals(a1,a2));

        // 修改一个元素后再进行比较
        a2[3] = 11;
        System.out.println("a1 == a2: " + Arrays.equals(a1,a2));

        // 初始化两个 int 包装类的数组
        Integer[] a1w = new Integer[SZ], a2w = new Integer[SZ];

        Arrays.setAll(a1w, new Count.Integer()::get);
        Arrays.setAll(a2w, new Count.Integer()::get);

        System.out.println("a1w == a2w: " + Arrays.equals(a1w, a2w));

        a2w[3] = 11;
        System.out.println("a1w == a2w: " + Arrays.equals(a1w, a2w));

        // 初始化二维字符串数组
        String[][] md1 = twoDArray(), md2 = twoDArray();

        System.out.println("md1: " + Arrays.deepToString(md1));
        System.out.println("md2: " + Arrays.deepToString(md2));
        System.out.println("deepEquals(md1, md2): " + Arrays.deepEquals(md1, md2));
        System.out.println("md1 == md2: " + Arrays.equals(md1, md2)); // 使用普通的数组比较方法
        md1[4][1] = "#$#$#$#";
        System.out.println(Arrays.deepToString(md1));
        System.out.println("deepEquals(md1, md2): " + Arrays.deepEquals(md1, md2));
    }

}
