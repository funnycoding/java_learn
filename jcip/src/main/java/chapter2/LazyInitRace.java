package chapter2;

import java.util.concurrent.atomic.AtomicInteger;
import net.jcip.annotations.NotThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/20 4:14 下午
 */

// 一个典型的 线程不安全的 最简单的单例模式的实现
//LazyInitRace.java
class ExpensiveObject {
    public ExpensiveObject() {
        System.out.println("单例对象的构造器被调用了！" + "调用线程： " + Thread.currentThread().getName());
    }
}

@NotThreadSafe
public class LazyInitRace {
    // 并不直接初始化，而是当真正使用的时候再对这个引用进行初始化
    private ExpensiveObject instance;
    AtomicInteger i = new AtomicInteger(0);
    public ExpensiveObject getInstance() {
        if (instance == null) {
            i.incrementAndGet();
            instance = new ExpensiveObject();
        }
        return instance;
    }
    public int getCount() {
        return i.intValue();
    }



    public void test() throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            Thread t = new Thread(this::getInstance);
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LazyInitRace li = new LazyInitRace();
        li.test();
    }
}

