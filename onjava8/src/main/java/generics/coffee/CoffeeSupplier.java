package generics.coffee;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 4:57 下午
 */
// generics/coffee/CoffeeSupplier.java
// {java generics.coffee.CoffeeSupplier}
// 实现一个 Coffee 类的生成器
public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    // 定义所有 Coffee 类型的 Class类字面量数组
    private Class<?>[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class};
    // 搞一个随机数
    private static Random rand = new Random(47);

    // 定义给迭代器使用的变量
    private int size = 0;

    public CoffeeSupplier() {
    }

    // 只是创建一个空的
    public CoffeeSupplier(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        // 不支持该操作
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            // 这里的 CoffeeSupplier.this 指向外部类实例。 因为 CoffeeIterator 是 CoffeeSupplier 的内部类
            return CoffeeSupplier.this.get();
        }
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier()) // Supplier 接口提供了生成对象的功能
                .limit(5)
                .forEach(System.out::println);
        System.out.println("------------");
        // 因为 CoffeeSupplier 实现了 Iterable 接口，所以可以使用 for-in遍历
        for (Coffee c : new CoffeeSupplier(5)) {
            System.out.println(c);
        }
    }
}
