package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 1:14 上午
 */

// 继承实现了逆向遍历的类
public class MultiIterableClass extends IterableClass {
    // 重新定义逆向遍历
    public Iterable<String> reserved() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int cuurent = words.length - 1;

                    @Override
                    public boolean hasNext() {
                        return cuurent > -1;
                    }

                    @Override
                    public String next() {
                        return words[cuurent--];
                    }
                };
            }
        };
    }

    // 多实现了一种迭代器 shuffled 随机排列元素
    public Iterable<String> randomizedI() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                ArrayList<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        System.out.println("逆向遍历");
        for (String s : mic.reserved()) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("shuffled 随机输出");
        for (String s : mic.randomizedI()) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("普通遍历");
        for (String s : mic) {
            System.out.print(s + " ");
        }
    }

}
