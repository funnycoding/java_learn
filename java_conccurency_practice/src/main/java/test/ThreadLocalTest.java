package test;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/26 4:32 下午
 */

public class ThreadLocalTest {
    // 创建2个 ThreadLocal
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    /**
     * 设置当前线程的ID和名称
     */
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong () {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }


    public static void main(String[] args) throws InterruptedException {
        // 不可变引用
        final ThreadLocalTest test1 = new ThreadLocalTest();

        test1.set();

        System.out.println(test1.getLong());
        System.out.println(test1.getString());

        // 开启一个新线程
        Thread thread1 = new Thread(() -> {
            test1.set();
            System.out.println(test1.getString());
            System.out.println(test1.getLong());
        });

        thread1.start();
        // 保证子线程执行完毕
        thread1.join();
        System.out.println("-----after join-----");
        System.out.println(test1.getLong());
        System.out.println(test1.getString());
    }
}
