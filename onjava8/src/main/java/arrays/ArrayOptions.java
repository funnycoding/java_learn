package arrays;

import static arrays.ArrayShow.show;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/6 11:45 下午
 */
// arrays/ArrayOptions.java
public class ArrayOptions {
    public static void main(String[] args) {
        // 对象数组
        BerylliumSphere[] a; // 未被初始化
        BerylliumSphere[] b = new BerylliumSphere[5]; // 开辟了长度为5个对象内存空间的数组
        show("b", b);

        // 隐式创建的数组，元素默认为 null
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            // 将 c 中的元素初始化
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }
        // 显示创建的数组
        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere()
        };

        // 动态聚合初始化
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};

        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length= " + a.length);

        // 基本类型的数组
        int[] e; // 空引用，尚未初始化的数组
        int[] f = new int[5];
        show("f",f);

        int[] g = new int[4];

        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{ 1, 2 };
        System.out.println("e.length = " + e.length);
    }
}
