package collections;

import java.util.Iterator;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 自己实现一个 实现 Iterable 并用 for-in 来遍历的类
 * @date 2020/2/16 11:34 下午
 */

public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped."
    ).split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }
}
