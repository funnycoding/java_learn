package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 11:27 下午
 */

public class Account2 {
    private int balance;
    // 转账
    void transfer(Account2 targer, int amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            targer.balance += amt;
        }
    }
}
