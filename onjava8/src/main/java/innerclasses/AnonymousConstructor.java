package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 2:34 下午
 */
abstract class Base {
    public Base(int i) {
        System.out.println("Base Constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        // 这里使用 new 创建对象时，会调用其构造器，构造器构造语句首先输出，然后是代码块，最后是f()函数中的输出语句
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }

}
