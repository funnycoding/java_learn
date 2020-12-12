import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/24 4:31 下午
 */

public class JavaEqualTest {
    // 声明2个变量，一个是基本类型位于栈上，一个是引用类型，其指针在栈，对象在堆
    private static Integer ii = 99999;
    private static String s = "50";


    public static void main(String[] args) {
        Integer i3 = new Integer(99999);
        String s1 = new String("50");
        System.out.println(ii.equals(i3));

        //输出 i 和 ii 的比较结果
        System.out.println(s == s1);
        System.out.println(s.equals(s1));

        MyObject a = new MyObject("A", 11);
        System.out.println("对象 a 的 hashCode:" + a.hashCode());
        MyObject b = new MyObject("A", 11);
        System.out.println("对象 b 的 hashCode:" + b.hashCode());

        System.out.println("使用 == 比较对象 a & b: " + (a == b));
        System.out.println("使用 equals 比较对象 a & b: " + (a.equals(b)));
    }

    @AllArgsConstructor
    private static class MyObject {
        private String name;
        private int num;
    }


}
