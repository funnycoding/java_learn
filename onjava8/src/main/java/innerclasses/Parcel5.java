package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:31 上午
 */

public class Parcel5 {
    // 方法作用域内创建一个完整的类，被称为局部内部类
    public Destination destination(String s) {
        // 方法内创建的类
        final class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination aaa = parcel5.destination("aaa");
        System.out.println(aaa.readLabel());
    }
}
