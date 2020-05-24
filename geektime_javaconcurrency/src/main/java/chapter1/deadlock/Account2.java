package chapter1.deadlock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/2 5:53 下午
 */

// 增加 id 字段，根据 id 从小到大申请资源，破除循环等待条件
public class Account2 {
    private int id;
    private int balance;

    //转账
    void transfer(Account2 target, int amt) {
        Account2 left = this;  // ①
        Account2 right = target; // ②
        if (this.id > target.id) {
            left = target; // ③
            right = this; // ④
        }
        // 锁定序号小的账户
        synchronized (left) {
            // 锁定序号大的账户
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
