package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:13 下午
 */

public class Parcel7b {
    // 对应匿名内部类，这里单独定义了一个有名字的类
    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    public Contents  contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b parcel7b = new Parcel7b();
        Contents contents = parcel7b.contents();
        System.out.println(contents.value());
    }

}
