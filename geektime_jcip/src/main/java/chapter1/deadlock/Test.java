package chapter1.deadlock;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/2 11:46 上午
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {
         Account a = new Account();
         Account b = new Account();
         Account c = new Account();

        for (int i = 0; i < 300; i++) {
            Thread t1 = new Thread(() -> {
                a.transfer(b, 100);
            });

            Thread t2 = new Thread(()->{
                b.transfer(c, 100);
            });

            Thread t3 = new Thread(()->{
                c.transfer(a, 100);
            });

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        }
        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());
    }
}
