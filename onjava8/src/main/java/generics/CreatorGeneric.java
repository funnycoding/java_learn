package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 8:22 下午
 */

// generics/CreatorGeneric.java
abstract class GenericWithCreate<T> {
    final T element;

    // 创造Creator 的时候就默认调用了子类的 create() ，创建了工厂目标对象的实例
    GenericWithCreate() {
        element = create();
    }

    // 让子类实现自己不同的工厂方法
    abstract T create();
}

class X {

}

// 类 X 的工厂类
class XCreator extends GenericWithCreate<X> {


    @Override
    X create() {
        return new X();
    }

    // 打印对象类名
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

}


public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}
