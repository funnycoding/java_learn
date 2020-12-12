package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/7 7:59 下午
 */

class Gizmo {
    public void spin() {

    }
}

public class FinalArguments {
    void with(final Gizmo g) {
        // g = new Gizmo(); Illegal ,g is final
    }

    void without(Gizmo g) {
        g = new Gizmo(); // it's ok
    }

    void f(final int i) {
        // i++; i is final, cant change
    }

    int g(final int i) {
        return i + 1;
    }

}
