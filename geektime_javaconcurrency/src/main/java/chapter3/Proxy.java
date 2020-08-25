package chapter3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/21 11:21 下午
 */

public class Proxy {
    boolean started = false;
    // 线程是否被中断的状态
    boolean terminated = false;

    // 采集线程
    Thread rptThread;


    // 任务队列
    BlockingQueue<Task> bq = new LinkedBlockingQueue<>(2000);

    // 启动采集功能
    synchronized void start() {
        if (started) {
            return;
        }
        started = true;
        terminated = false;
        rptThread = new Thread(() -> {
            // 通过判断线程的中断状态来决定是否执行采集逻辑
            while (!terminated) {
                // 具体的采集，回传业务逻辑的实现
                report();
                // 每隔2秒采集回传一次数据
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // 异常处理会清除线程的中断状态，所以这里重新将线程状态设置为 true
                    Thread.currentThread().interrupt();
                }
            }
            // 执行到这里时说明线程马上要终止了，run 方法执行完毕
            started = false;
        });
        rptThread.start();
    }

    // 终止采集数据功能
    synchronized void stop() {
        // 设置中断标志位
        terminated = true;

        // 中断线程 rptThread
        rptThread.interrupt();
    }

    public static void main(String[] args) {



    }

    // 启动5个消费者线程执行批量任务
    void start() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                try {
                    while (true) {
                        // 批量获取任务
                        List<Task> ts = pollTasks();
                        // 批量执行任务
                        execTasks(ts);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    List<Task> pollTasks() throws InterruptedException {
        List<Task> ts = new LinkedList<>();

        // 使用阻塞式获取第一条任务

        Task t = bq.take();
        while (t != null) {
            ts.add(t);
            // 非阻塞的获取一条任务
            t = bq.poll();
        }
        return ts;
    }

    // 批量执行任务
    void execTasks(List<Task> ts) {
        // 省略具体执行逻辑
    }
}
