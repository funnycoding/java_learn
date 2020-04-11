package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/11 12:05 上午
 */

// 使用 Account.Class 作为锁
public class Account4 {
    private int balance;

    void transger(Account4 target,int amt) {
        synchronized (Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}
