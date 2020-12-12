package typeinfo.packageaccess;

import typeinfo.A;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 9:22 下午
 */
// typeinfo/packageaccess/HiddenC.java
class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }
    public void g() {
        System.out.println("public c.g()");
    }
    void u () {
        System.out.println("packge C.u()");
    }
    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
