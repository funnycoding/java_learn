package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:50 下午
 */

public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            private String label = dest;

            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget");
                }
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination a = parcel10.destination("A", 101.5F);
        System.out.println(a.readLabel());
    }
}
