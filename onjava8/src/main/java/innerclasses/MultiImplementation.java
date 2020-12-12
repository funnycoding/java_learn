package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 4:00 下午
 */

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

public class MultiImplementation {
    static void takesD(D d) {

    }

    static void takesE(E e) {

    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
