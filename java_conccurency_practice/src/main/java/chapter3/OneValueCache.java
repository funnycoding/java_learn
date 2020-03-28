package chapter3;

import java.math.BigInteger;
import java.util.Arrays;
import net.jcip.annotations.Immutable;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/26 7:27 下午
 */

// 使用不可变类缓存因式分解的数值和结果
// OneValueCache.java
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastfactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        // 这是一个关键操作，如果不适用 Arrays.copyOf 则无法保证原子性
        this.lastfactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            // 返回的都是数组的拷贝副本
            return Arrays.copyOf(lastfactors, lastfactors.length);
        }
    }
}
