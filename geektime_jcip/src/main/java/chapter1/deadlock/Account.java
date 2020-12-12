package chapter1.deadlock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/2 11:46 上午
 */

public class Account {
    // Allocator 应该是单例的
    private Allocator actr;
    // 初始值是200
    private int balance = 200;

    // 转账
    void transfer(Account target,int amt) {
            // 同时申请需要的 转出账户和转入账户，直到申请成功为止
            try {
                // 锁定转出账户
                synchronized(this) {
                    // 锁定转入账户
                    synchronized (target) {
                        if (this.balance > amt) {
                            this.balance -= amt;
                            target.balance += amt;
                        }
                    }
                }
            } finally {
                // 释放资源
            }
    }

    public int getBalance() {
        return balance;
    }
}
