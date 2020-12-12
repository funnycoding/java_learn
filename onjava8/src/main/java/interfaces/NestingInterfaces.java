package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 10:47 下午
 */

class A {
    // 内嵌接口
    interface B {
        void f();
    }

    // 内部类
    public class BImp implements B {

        @Override
        public void f() {

        }
    }

    // 内部类2
    public class BImp2 implements B {
        @Override
        public void f() {

        }
    }

    // 内部接口2
    public interface C {
        void f();
    }

    // 内部接口实现类
    class CImp implements C {
        @Override
        public void f() {

        }
    }

    // 内部接口私有实现类2
    private class CImp2 implements C {
        @Override
        public void f() {

        }
    }

    // 私有内部接口D
    private interface D {
        void f();
    }

    // 私有内部接口的私有内部实现类
    private class DImp implements D {
        @Override
        public void f() {

        }
    }


    // 私有内部接口的 public 实现类
    public class DImp2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    // 将传入的D 赋值给 ref 引用并调用f方法，目测是切换 DIMP2 和 DIMP1的对象实例
    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {
    interface G {
        void f();
    }

    // Redundant "public"
    public interface H {
        void f();
    }

    void g();
    // Cannot be private within an interface
    //- private interface I {}
}


public class NestingInterfaces {
    // 继承A的嵌套接口
    public class BImp implements A.B {

        @Override
        public void f() {

        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

    // Cannot implements a private interface except 私有接口无法嵌套 比如 A.D
    // within that interface's defining class:
    //- class DImp implements A.D {
    //- public void f() {}
    //- }

    class EImp implements E {
        @Override
        public void g() {
        }
    }


    class EGImp implements E.G {
        @Override
        public void f() {
        }
    }

    class EImp2 implements E {
        @Override
        public void g() {
        }

        // 嵌套类实现嵌套接口
        class EG implements E.G {
            @Override
            public void f() {
            }
        }

    }

    public static void main(String[] args) {
        A a = new A();
        // Can't access to A.D: 因为 D是私有类 所以 无法获取 A.D 对象
        //- A.D ad = a.getD();
        // Doesn't return anything but A.D:
        //- A.DImp2 di2 = a.getD();

        A a2 = new A();
        a2.receiveD(a.getD());
    }


}
