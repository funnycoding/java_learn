package typeinfo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 10:31 下午
 */
// typeinfo/InnerImplementation.java
class InnerA {
    //私有静态内部类实现接口A
    private static class C implements A {

        @Override
        public void f() {
            System.out.println("public C.f()");
        }

        public void g() {
            System.out.println("public C.g()");
        }

        void u() {
            System.out.println("package C.u()");
        }

        protected void v() {
            System.out.println("protected C.v()");
        }

        private void w() {
            System.out.println("private C.w()");
        }
    }

    public static A makeA() {
        return new C();
    }
}

public class InnerImplementation {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 反射仍然可以调用私有静态内部类的方法
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
