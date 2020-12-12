package streams;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 11:00 下午
 */

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        Repeat.repeat(3,()-> System.out.println("Looping!~"));
        Repeat.repeat(2,Looping::hi);

    }
}
