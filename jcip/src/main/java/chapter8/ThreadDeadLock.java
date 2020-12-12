package chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/4 6:52 下午
 */

// 会经常发生死锁的例子
public class ThreadDeadLock {
    // 串行Executor
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class LoadFileTask implements Callable<String> {
        private final String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public String call() throws Exception {
            // 这里是读取 File 内容的业务逻辑；
            return "";
        }
    }

    public class RenderPage implements Callable<String> {
        @Override
        public String call() throws Exception {
            // 定义获取页眉和页脚任务的 Future 引用，用于获取其任务执行完的内容
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // 在这里将发生死锁，因为渲染页面的任务等待获取 header 和 footer 任务的结果
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            // 这里是实际渲染页面的业务逻辑
            return "";
        }
    }
}

