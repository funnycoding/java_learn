package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 1:14 下午
 */

abstract class Uninstantiable {
    abstract void f();

    abstract int g();
}

public class Instantiable extends Uninstantiable {
    @Override
    void f() {
        System.out.println("f()");
    }

    @Override
    int g() {
        return 22;
    }

    public static void main(String[] args) {
        Instantiable instantiable = new Instantiable();
    }
}
