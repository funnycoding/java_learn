package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import onjava.Count;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 2:55 下午
 */
// ArrayCopying.java
class Sup {
    private int id;

    public Sup(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class Sub extends Sup {
    public Sub(int id) {
        super(id);
    }
}


public class ArrayCopying {
    public static final int SZ = 15;

    public static void main(String[] args) {
        int[] a1 = new int[SZ];

        Arrays.setAll(a1, new Count.Integer()::get);

        show("a1", a1);

        int[] a2 = Arrays.copyOf(a1, a1.length); // [1]

        // 证明 a1 a2 是不同的数组：
        Arrays.fill(a1, 1); // 将 a1 的所有元素改为1
        show("a1", a1);
        show("a2", a2);
        // 将 a2 数组的长度进行扩容 没有被初始化的元素都是默认值 0
        a2 = Arrays.copyOf(a2, a2.length + 5); // [2]
        show("a2", a2);

        // 对包装类进行 Copy
        Integer[] a3 = new Integer[SZ]; // [3]
        Arrays.setAll(a3, new Count.Integer()::get);
        show("a3", a3);
        Integer[] a4 = Arrays.copyOfRange(a3, 4, 12); // 左闭右开 (] 5-12
        show("a4", a4);
        a4 = Arrays.copyOf(a4, a4.length + 5);
        show("a4 after expansion ", a4);

        Sub[] d = new Sub[SZ / 2];
        Arrays.setAll(d, Sub::new);
        show("d", d);
        // 拷贝子类数组转为父类引用
        Sup[] b = Arrays.copyOf(d, d.length, Sup[].class);// [4]
        show("b",b); // 这里打印的元素还是具体的子类类型，没有向上转型打印出父类 Sup

        Sub[] d2 = Arrays.copyOf(b, b.length, Sub[].class); // [5]
        show("d2",d2);
        Sup[] b2 = new Sup[SZ / 2];
        Arrays.setAll(b2, Sup::new);
        show("b2", b2);

        try {
            Sub[] d3 = Arrays.copyOf(b2, b2.length, Sub[].class); // [6]
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
