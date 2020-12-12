package polymorphism;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 1:57 下午
 */

class Useful {
    public void f() {
        System.out.println("Useful");
    }

    public void g() {
        System.out.println("Useful");
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {
        System.out.println("More Useful");
    }

    @Override
    public void g() {
        System.out.println("More Useful");
    }

    public void u() {
        System.out.println("More Useful");
    }

    public void v() {
        System.out.println("More Useful");
    }
}


public class RTTI {
    public static void main(String[] args) {
        Useful[] usefuls = {
                new Useful(),
                new MoreUseful()
        };
        usefuls[0].f();
        usefuls[1].g();

        ((MoreUseful) usefuls[1]).v();
        if (usefuls[0] instanceof MoreUseful) {
            ((MoreUseful) usefuls[0]).g();
        }
    }
}
