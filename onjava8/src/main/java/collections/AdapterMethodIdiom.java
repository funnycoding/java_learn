package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 12:55 上午
 */

// 创建一个支持逆向遍历元素的类
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    // 逆向遍历的具体实现
    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));

        System.out.println("开始正向遍历");
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("开始逆向遍历");
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }
    }
}
