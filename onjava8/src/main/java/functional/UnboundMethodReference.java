package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 没有方法引用的对象
 * @date 2020/2/17 5:56 下午
 */

// UnboundMethodReference.java
class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    // 这里方法的参数是一个 X 类型的对象，后面就可以看到这个入参的作用。
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        MakeString ms = new X()::f; // [1] 典型的非静态方法引用的绑定，先构造对象，然后将方法引用赋值给接口

        // 这里的方法引用赋值如果是第一次的话会很懵逼
        // 方法签名既不一致，而且 f() 也不是静态方法，为什么可以使用 类::方法的形式
        // 这里因为接口的方法的第一个参数是对应类，所以就存在了一个隐式 this 的赋值过程，方法绑定的时候会将对象赋值给第一个指定对象的类型参数，实现与构造对象相同的效果
        TransformX sp = X::f;

        X x = new X();
        // 这三个语句效果一样，都是调用 X 类的 f() 函数
        System.out.println(sp.transform(x));
        System.out.println(x.f());
        System.out.println(ms.make());
    }
}
