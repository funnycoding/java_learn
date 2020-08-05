package chapter1.deadlock;

import java.util.List;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 使用 等待—通知 机制实现的分配器
 * @date 2020/7/26 9:14 下午
 */

public class Allocator2 {
    private List<Object> als;

    // 一次性申请所有资源
    synchronized void apply(Object from, Object to) {
        // 经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        als.add(from);
        als.add(to);
    }

    // 释放资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

}
