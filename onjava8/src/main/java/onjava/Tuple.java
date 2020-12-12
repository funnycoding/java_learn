// onjava/Tuple.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Tuple library using type argument inference
package onjava;

// 使用5个重载的静态泛型方法生成不同的元组对象
public class Tuple {

    // 创建一个包含2种对应入参类型的 Tuple2 元组对象
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    // 这里返回值后面跟的泛型其实不属于方法泛型的范畴，而是给返回的 Tuple3 对象定义为泛型类，而不是 RawType
    // 我第一次看到的时候还以为是方法泛型的一部分，所以有点懵逼
    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);

    }

    public static <A, B, C, D, E>
    Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<>(a, b, c, d, e);
    }

}
