package streams;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 8:45 下午
 */
// SelectElement.java
public class SelectElement {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().findFirst().getAsInt());
        System.out.println(RandInts.rands().parallel().findFirst().getAsInt());
        System.out.println(RandInts.rands().findAny().getAsInt());
        System.out.println(RandInts.rands().parallel().findAny().getAsInt());
    }
}
