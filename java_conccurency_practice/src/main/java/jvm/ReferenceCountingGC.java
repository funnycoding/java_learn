package jvm;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/18 4:56 下午
 */

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    // 这个实例字段的意义是占点内存，以便能在 GC 日志中看清楚是否回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        // 循环引用
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这里发生 GC 那么 A 和 B 是否能被回收呢？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
