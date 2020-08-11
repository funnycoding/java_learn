//package chapter1;
//
//import java.util.Queue;
//
///**
// * @author XuYanXin
// * @program javaconcurrency_learn
// * @description
// * @date 2020/8/6 3:14 下午
// */
//
//public class Semaphore {
//
//    static int count;
//
//    // 初始化信号量
//    static final Semaphore s = new Semaphore(1);
//
//    // 使用信号量保证互斥
//
//    static void addOne() {
//        s.acquire();
//        try {
//            count += 1;
//        } finally {
//            s.release();
//        }
//    }
//
//
//    // 等待队列
//    Queue queue;
//
//    // 计数器初始化操作
//    Semaphore(int c) {
//        this.count = c;
//    }
//
//    void down() {
//        this.count--;
//        if (this.count < 0) {
//            // 将当前线程插入等待队列
//            // 阻塞当前线程
//        }
//    }
//
//    void up() {
//        this.count++;
//        if (this.count <= 0) {
//            // 唤醒等待队列中的某个线程
//            // 唤醒线程T
//        }
//    }
//}
