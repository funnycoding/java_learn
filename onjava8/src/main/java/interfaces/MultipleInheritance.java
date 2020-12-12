package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 2:29 下午
 */

interface One {
    default void first() {
        System.out.println("first");
    }
}

interface Two {
    default void second() {
        System.out.println("second");
    }
}

interface Three {
    default int first(int i) {
        System.out.println("third");
        return i;
    }
}

class MI implements One, Two, Three {

}

public class MultipleInheritance {
    public static void main(String[] args) {
        MI mi = new MI();
        mi.first();
        mi.second();
    }
}
