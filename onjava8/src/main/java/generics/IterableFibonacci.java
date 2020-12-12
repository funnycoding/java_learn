package generics;

import java.util.Iterator;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 8:33 下午
 */
// IterableFibonacci.java
// 继承生成斐波那契的类并使用适配器模式增加其Iterable特性，使其可以使用 for-in 算法
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                // 通过 Supplier 的 get() 生成 斐波那契数列
                return IterableFibonacci.this.get();
            }

            // 不支持的操作
            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
