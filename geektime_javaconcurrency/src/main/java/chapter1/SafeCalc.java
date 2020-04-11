package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 3:20 下午
 */

public class SafeCalc {
    long value = 0L;

    synchronized long get() {
        return value;
    }

    synchronized void addOne() {
        value += 1;
    }
}


