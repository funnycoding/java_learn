package chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/6 3:12 下午
 */

// 一个关于 桌面搜索程序的对生产者和消费者的应用实例
public class ProducerConsumer {

    /**
     * 用来抓取桌面文件内容的生产者
     */
    static class FileCrawler implements Runnable {
        // 阻塞队列，用于存储要索引的文件
        private final BlockingQueue<File> fileQueue;
        // 文件的过滤器，判断是否要将文件放入队列
        private final FileFilter fileFilter;
        // 具体的被处理的队列中的生产资源，在这个例子中是file
        private final File root;

        public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
            this.fileQueue = fileQueue;
            this.root = root;
            // 重写了 accept 方法
            this.fileFilter = f -> f.isDirectory() || fileFilter.accept(f);
        }

        // 返回是否已经对文件进行索引，但是这里没有进行判断，直接返回的就是 false
        private boolean alreadyIndexed(File file) {
            return false;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        /**
         * 将桌面中的所有 文件放入 fileQueue 中
         *
         * @param root
         * @throws InterruptedException
         */
        private void crawl(File root) throws InterruptedException {
            File[] entries = root.listFiles(fileFilter);
            if (entries != null) {
                for (File entry : entries) {
                    if (entry.isDirectory()) {
                        crawl(entry);
                    }
                    // 但是这里 返回的肯定是 false 然后 变成 true 进入 put 逻辑
                    else if (!alreadyIndexed(entry)) {
                        fileQueue.put(entry);
                    }
                }
            }
        }
    }

    // 消费者，获取队列中的元素，这里是文件，然后对其进行索引（方法逻辑未实现，只是列出其逻辑）
    static class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            try {
                while (true) {
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                // 发生异常就使线程停止
                Thread.currentThread().interrupt();
            }
        }

        public void indexFile(File file) {
            // 对文件进行索引编号的方法，这里书中并没有实现具体逻辑
        }
    }

    // 设定队列的界限
    private static final int BOUND = 10;

    // 设置消费者的数量，这里是获取当前运行环境的CPU核心数并将其设置为消费者数量
    private static final int N_CONSUMERS = Runtime.getRuntime().availableProcessors();

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(BOUND);

        FileFilter filter = pathname -> true;

        // 生产者,将文件放入 queue 中，填充要标记的文件队列
        for (File root : roots) {
            // 每个 roots 分配一个线程用来填充要进行标记的文件队列
            new Thread(new FileCrawler(queue, filter, root)).start();
        }

        // 消费者,消费队列中的文件，对其进行 indexFile() 标记方法
        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
