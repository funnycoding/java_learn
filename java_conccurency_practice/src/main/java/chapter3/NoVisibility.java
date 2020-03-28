package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/24 3:22 下午
 */
// NoVisibility.java
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            // 当读线程无法访问到主线程给 ready 的赋值的时候，会一直进入这个循环
            while (!ready) {
                System.out.println("ready = true");
                Thread.yield();
            }
            // 输出的值可能是42 也可能是0 因为读线程获取到的 number 值 可能在主线程给 number 赋值之前获取到
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
