package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 10:43 下午
 */


public class Parcel3 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String whereTo) {
            this.label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p3 = new Parcel3();
        // Must use instance of outer class 必须使用外部类的实例
        // to create an instance of the inner class 创建一个内部类对象
        Contents contents = p3.new Contents();
        Parcel3.Destination destination = p3.new Destination("aa");
    }


}
