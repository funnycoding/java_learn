package chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/10 5:02 下午
 */

public class SimulatedCAS {
    volatile int count;
    AtomicLong count2 = new AtomicLong(0);
    // 实现count+=1
    void addOne() {
        count2.getAndIncrement();
        int newValue;
        do {
            newValue = count + 1;
        } while (count != cas(count, newValue));
    }

    synchronized int cas(int expect, int newValue) {
        // 读取当前count的值
        int curValue = count;
        // 比较当前count是否和期望值相等
        if (curValue == expect) {
            count = newValue;
        }
        // 返回写入前的值
        return curValue;
    }
}
