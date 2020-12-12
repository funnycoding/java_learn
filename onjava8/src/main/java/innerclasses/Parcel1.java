package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 内部类的第一个例子，比较简单的说明其语法
 * @date 2020/2/12 5:32 下午
 */

// 外围类
public class Parcel1 {
    // 内部类1
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    // 内部类2
    class Destination {
        private String lable;

        public Destination(String lable) {
            this.lable = lable;
        }

        String readLabel() {
            return lable;
        }
    }

    // Using inner classes looks just like
    // using any other class, within Parcel1:
    // 就像使用其他独立的类一样使用内部类


    // 创建两个内部类的对象 并调用 destination 的方法
    public void ship(String dest) {

        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("Tasmania");
    }


}
