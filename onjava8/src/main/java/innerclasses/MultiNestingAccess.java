package innerclasses;


import innerclasses.MNA.A;
import innerclasses.MNA.A.B;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 3:28 下午
 */

class MNA {
    private void f() {
        System.out.println("MNA f()");
    }

    class A {
        private void g() {
            System.out.println("MNA.A g()");
        }

        // 最内层嵌套类分别调用其外面两层的函数
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();
        A a = mna.new A();
        B b = a.new B();
        b.h();
    }
}
