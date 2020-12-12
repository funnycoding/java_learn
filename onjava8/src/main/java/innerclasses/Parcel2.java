package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 5:45 下午
 */

public class Parcel2 {
    // 内部类1
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    // 构建一个内部类的对象
    public Destination to(String s) {
        return new Destination(s);
    }

    // 构建内部类 Contents 对象
    public Contents contents() {
        return new Contents();
    }


    public void ship(String dest) {
        // 调用构造Contents 和 Destination 对象的方法
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmania");

        Parcel2 q = new Parcel2();
        Contents contents = q.contents();
        Destination borneo = q.to("Borneo");
    }


}
