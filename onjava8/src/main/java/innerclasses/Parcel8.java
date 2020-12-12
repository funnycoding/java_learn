package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:16 下午
 */

public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Base Constructor call:
        return new Wrapping(x) {
            // 覆写了基类的方法
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(10);
        System.out.println(wrapping.value());
    }
}
