package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 11:57 下午
 */

// 传入额外的对象作为唯一的锁
public class Accoutn3 {
    // 用来作为保护多个资源的单一锁对象
    private Object lock;

    private int balance;

    // 创建 Account 时需要传入同一个 lock 对象
    private Accoutn3(Object lock) {
        this.lock = lock;
    }

    // 转账
    void transfer(Accoutn3 target, int amt) {
        synchronized (lock) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}
