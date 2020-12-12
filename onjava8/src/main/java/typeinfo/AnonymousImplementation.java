package typeinfo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 10:34 下午
 */
// typeinfo/AnonymousImplementation.java
class AnonymousA {
    public static A makeA() {
        // 返回一个A的匿名对象
        return new A() {
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
        };
    }
}

public class AnonymousImplementation {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 反射仍然可以调用匿名类对象的所有方法
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");

    }
}
