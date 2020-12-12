package chapter5;

import java.util.Vector;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/5 4:17 下午
 */

// 在调用线程安全的容器类时进行客户端加锁来保证操作的原子性
public class SafeVectorHelpers {
    /**
     * 原子操作的获取 Vector 上的最后一个元素
     *
     * @param list
     * @return
     */
    public static Object getLast(Vector list) {
        // 获取容器类的锁，保证在操作 list 容器时 没有其他线程可以修改该容器
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    /**
     * 原子操作的删除 Vector 上的最后一个元素
     *
     * @param list
     */
    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
