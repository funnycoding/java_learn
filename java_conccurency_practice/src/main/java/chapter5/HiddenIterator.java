package chapter5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/5 10:12 下午
 */
// 通过 toString 隐藏的调用容器的迭代器
public class HiddenIterator {
    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer integer) {
        set.add(integer);
    }

    public synchronized void remove(Integer integer) {
        set.remove(integer);
    }

    public void addTenThings() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            add(random.nextInt());
        }
        // 在这里打印集合将迭代集合中的每个元素，并对每个元素调用 toString() 方法
        System.out.println("Debug: added ten elemnts to " + set);
    }

    public static void main(String[] args) {
        HiddenIterator hi = new HiddenIterator();
        hi.addTenThings();
    }
}
