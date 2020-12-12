package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 1:57 下午
 */

public class Parcel7 {
    public Contents content() {

        return new Contents() { // 返回接口的一个匿名对象，实现了接口
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        }; // 这里需要分号，因为这是一个完整的语句
    }

    public static void main(String[] args) {
        Parcel7 p7 = new Parcel7();
        Contents content = p7.content();
        System.out.println(content.value());
    }
}
