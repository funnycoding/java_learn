package generics;

import static onjava.Tuple.tuple;

import onjava.Tuple;
import onjava.Tuple2;
import onjava.Tuple3;
import onjava.Tuple4;
import onjava.Tuple5;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 12:07 下午
 */

// TupleTest2.java
public class TupleTest2 {
    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    // 返回 RawType Tuple
    static Tuple2 f2() {
        return Tuple.tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }
    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(
                new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(),
                "hi", 47, 11.1);
    }

    public static void main(String[] args) {

        Tuple2<String,Integer> tuple2 = f2();

        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(tuple2);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
