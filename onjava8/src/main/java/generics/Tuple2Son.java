package generics;


import onjava.Tuple2;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 2:51 上午
 */

// Tuple2Son
// 定义一个元组类的子类，这样就又多了一种C类型可以使用，但是缺点就是要明确父类的类型
//public class Tuple2Son<C> extends Tuple2<String, Integer> {
public class Tuple2Son<C> extends Tuple2<String, Integer> {
    public C c;

    public Tuple2Son(String a1, Integer a2, C c) {
        super(a1, a2);
        this.c = c;
    }
}
