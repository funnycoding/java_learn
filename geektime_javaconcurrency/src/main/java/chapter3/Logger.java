package chapter3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/24 12:58 上午
 */

public class Logger {
    // 任务队列
    final BlockingQueue<LogMsg> bq = new LinkedBlockingQueue<>();

    // flush 批量
    static final int batchSize = 500;

    // 只需要一个线程写日志
    ExecutorService es = Executors.newFixedThreadPool(1);

    // 启动写日志线程
    void start() throws IOException {
        File file = File.createTempFile("foo", ".log");

        final FileWriter writer = new FileWriter(file);

        this.es.execute(() -> {
            try {
                // 未刷盘日志数量
                int curIdx = 0;
                long preFT = System.currentTimeMillis();
                while (true) {
                    // 获取5秒内的所有日志消息
                    LogMsg log = bq.poll(5, TimeUnit.SECONDS);
                    // 写日志
                    if (log != null) {
                        writer.write(log.toString());
                        ++curIdx;
                    }
                    // 如果不存在未刷盘数据，则无需执行保存操作
                    if (curIdx <= 0) {
                        continue;
                    }

                    // 根据规则刷盘
                    if (log != null && log.level == LEVEL.ERROR || curIdx == batchSize
                            || System.currentTimeMillis() - preFT > 5000) {
                        writer.flush();
                        curIdx = 0;
                        preFT = System.currentTimeMillis();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // 写入 INFO 级别的日志到队列中
    void info(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.INFO, msg));
    }

    // 写入 ERROR 级别的日志到队列中
    void error(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.ERROR, msg));
    }

    //日志级别
    enum LEVEL {INFO, ERROR}

    class LogMsg {
        LEVEL level;
        String msg;

        public LogMsg(LEVEL level, String msg) {
            this.level = level;
            this.msg = msg;
        }
    }
}
