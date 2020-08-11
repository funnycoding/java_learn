import java.util.concurrent.locks.StampedLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/9 2:10 上午
 */

public class StampedDemo {
    public static void main(String[] args) {
        final StampedLock sl = new StampedLock();

        // 获取/释放 悲观读锁
        long readStamp = sl.readLock();
        try {
            //相关业务代码在这里写
        }finally {
            sl.unlockRead(readStamp);
        }

        // 获取/释放 悲观写锁
        long writeStamp = sl.writeLock();
        try {
            //相关业务代码在这里写
        }finally {
            sl.unlockWrite(writeStamp);
        }
    }
}
