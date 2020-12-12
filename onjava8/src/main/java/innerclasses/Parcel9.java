package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:23 下午
 */

public class Parcel9 {
    // Argument must be final or "effectively final"
    // to use within the anonymous inner class:
    // 使用匿名内部类时，入参必须是不可变参数
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination dest = parcel9.destination("Parcel9");
        System.out.println(dest.readLabel());
    }

}
