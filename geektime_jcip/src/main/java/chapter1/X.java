package chapter1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/30 3:12 下午
 */

public class X {
    private final Lock rtl = new ReentrantLock();
    int value;


    public int get() {
        // 获取锁
        rtl.lock(); // ②
        try {
            return value;
        }finally {
            rtl.unlock();
        }
    }

    public void addOne() {
        // 获取锁
        rtl.lock();
        try {
            value += 1+get(); //①
        }finally {
            // 保证锁释放
            rtl.unlock();
        }
    }
}
