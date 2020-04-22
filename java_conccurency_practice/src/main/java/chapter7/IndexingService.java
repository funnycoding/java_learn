package chapter7;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/21 10:10 下午
 */

// 使用毒丸对象终止服务
public class IndexingService {
    private static final int CAPACITY = 1000;
    private static final File POISON = new File("");
    private final IndexerThread consumer = new IndexerThread();
    private final CrawlerThread producer = new CrawlerThread();
    private final BlockingQueue<File> queue;
    private final FileFilter fileFilter;
    private final File root;


    public IndexingService(BlockingQueue<File> queue, FileFilter fileFilter, File root) {
        this.queue = new LinkedBlockingQueue<>(CAPACITY);
        this.fileFilter = f -> f.isDirectory() || fileFilter.accept(f);
        this.root = root;
    }

    private boolean alreadyIndexed(File entry) {
        return false;
    }

    // 消费者的逻辑，判断从队列中取到是否为毒丸对象，如果不是就持续消费
    class IndexerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    final File file = queue.take();
                    if (file == POISON) {
                        break;
                    } else {
                        indexFile(file);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void indexFile(File file) {
            // ... 具体业务逻辑 这里省略
        }
    }

    // 生产者的逻辑，当文件抓取完成后持续向队列中放入毒丸对象
    class CrawlerThread extends Thread {
        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 当抓取完成后开始持续放入毒丸对象来关闭这个任务
                while (true) {
                    try {
                        // 放入毒丸对象
                        queue.put(POISON);
                        break;
                    } catch (InterruptedException e) {
                        // 重试
                    }
                }
            }
        }
    }

    // 抓取文件的方法
    private void crawl(File root) throws InterruptedException {
        final File[] entries = root.listFiles(fileFilter);

        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    queue.put(entry);
                }
            }
        }
    }
}
