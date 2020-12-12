package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 9:16 下午
 */
// InterfaceViolation.java
class B implements A {
    @Override
    public void f() {
        System.out.println("B.f()");
    }
    public void g() {
        System.out.println("B.g()");
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        //a.g() //编译异常，因为g是子类实现的方法，接口中并不包含
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
