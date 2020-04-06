package chapter5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/6 10:17 下午
 */

// 使用信号量 Semaphore 给 容器设置边界
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        // 设置边界
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        // 信号量 +1
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            // 如果没有成功保存元素，则信号量 -1
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);

        if (wasRemoved) {
            // 信号量 -1
            sem.release();
        }
        return wasRemoved;
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<String> strSet = new BoundedHashSet<>(3);
        strSet.add("1");
        strSet.add("2");
        strSet.add("3");
        System.out.println(strSet.set);
        System.out.println(strSet.sem.toString());
        strSet.add("4");
        System.out.println("66");
    }
}
