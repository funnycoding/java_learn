package generics;

import java.util.ArrayList;
import onjava.Tuple4;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 7:53 下午
 */

// TupleList.java
// 这个是一个继承ArrayList，并且 ArrayList的类型参数是 Tuple4<A,B,C,D> 的 Tuple4 列表类

public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        Tuple4<Vehicle, Amphibian, String, Integer> h = TupleTest2.h();
        tl.add(h);
        tl.forEach(System.out::println);
    }
}
