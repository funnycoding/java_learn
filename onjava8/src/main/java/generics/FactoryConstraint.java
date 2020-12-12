package generics;

import arrays.Suppliers;
import generics.Widget.Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 8:07 下午
 */

// generics/FactoryConstraint.java
class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return i++;
    }
}


class Widget {
    private int id;

    public Widget(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    // Widget 的工厂
    public static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }

}

class Fudge {
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    // 生成 5个 Supplier 工厂生产的对象
    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}


public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2<>(new IntegerFactory()));
        System.out.println(new Foo2<>(new Factory()));
        System.out.println(new Foo2<>(Fudge::new));
    }
}
