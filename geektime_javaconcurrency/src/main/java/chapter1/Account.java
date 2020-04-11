package chapter1;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/10 10:49 下午
 */

public class Account {
    // 保护账余额的锁
    private final Object balanceLock = new Object();

    // 账户余额
    private Integer balance;

    // 保护账户密码的锁
    private final Object passwordLock = new Object();

    // 账户密码
    private String password;

    //取款
    void withdraw(Integer amt) {
        synchronized (this.balance) {
            if (this.balance > amt) {
                // 取款操作
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balanceLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (passwordLock) {
            this.password = pw;
        }
    }

    // 查看密码

    String getPassword() {
        synchronized (passwordLock) {
            return this.password;
        }
    }
}
