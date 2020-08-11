import java.util.concurrent.locks.StampedLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/9 2:30 上午
 */

public class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();

    //计算到原点的距离
    double distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入局部变量，读的过程数据可能被修改(将类字段赋值给方法中的局部变量）
        int curX = x, curY = y;
        // 判断执行读操期间类变量是否被修改过，如果修改过则 validate 方法返回 false
        if (!sl.validate(stamp)) {
            // 如果被修改过，将乐观读升级为悲观读锁
            stamp = sl.readLock();
            try {
                // 重新赋值
                curX = x;
                curY = y;
            } finally {
                // 释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }
}
