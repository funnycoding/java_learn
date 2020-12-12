package chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/1 9:12 下午
 */

// 一个非线程安全的类，2个原子变量并不能组成原子操作
public class NumberRange {
    // 约束： lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // 警告：不安全的检查后执行 check-then-act
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + "> upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // 警告：不安全的检查后执行 check-then-act
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + "< lower");
        }
        upper.set(i);
    }

    // 判断 i 是否在正确性约束区间内
    public boolean isInrage(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
