package chapter5;

import java.util.Vector;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/5 3:52 下午
 */

// 非线程安全的类，对 Vector 进行复合操作可能带来令人困惑的结果
// UnsafeVecotrHelpers.java
public class UnsafeVecotrHelpers {
    /**
     * 获取当前 Vector 的最后一个元素
     *
     * @param list
     * @return
     */
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    /**
     * 移除当前 Vector 的最后一个元素
     *
     * @param list
     */
    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
