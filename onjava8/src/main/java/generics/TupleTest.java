package generics;

import onjava.Tuple2;
import onjava.Tuple3;
import onjava.Tuple4;
import onjava.Tuple5;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 3:09 下午
 */
// TupleTest.java
public class TupleTest {
    static Tuple2<String, Integer> f() {
        // 47 自动装箱为 Integer
        return new Tuple2<>("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);

        //ttsi.a1 = "55"; // 编译错误 final 变量不能重新赋值
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
