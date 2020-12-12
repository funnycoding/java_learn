package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 10:35 下午
 */

public class DotNew {
    public class Inner{
        void say() {
            System.out.println("Inner say");
        }
    }

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        Inner inner = dotNew.new Inner();
        inner.say();
    }
}
