package chapter1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/30 5:52 下午
 */
public class LockAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    // 转账
    void transfer(LockAccount tar,int amt) {
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (tar.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                        }finally {
                            tar.lock.unlock();
                        }
                    }
                }finally {
                    this.lock.unlock();

                }
            }
        }
    }
}
