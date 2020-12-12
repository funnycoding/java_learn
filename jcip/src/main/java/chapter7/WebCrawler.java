package chapter7;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.jcip.annotations.GuardedBy;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/23 12:36 下午
 */
// 使用 TrackingExecutorService 来保存未完成的抓取任务，以便下次启动时重新抓取
public abstract class WebCrawler {
    private volatile TrackingExecutor exec;
    @GuardedBy("this")
    private final Set<URL> urlsToCrawl = new HashSet<>();
    private final ConcurrentMap<URL, Boolean> seen = new ConcurrentHashMap<>();
    private static final long TIMEOUT = 500;
    private static final TimeUnit UNIT = TimeUnit.MILLISECONDS;

    public WebCrawler(URL startUrl) {
        urlsToCrawl.add(startUrl);
    }

    public synchronized void start() {
        exec = new TrackingExecutor(Executors.newCachedThreadPool());
        urlsToCrawl.forEach(this::submitCrawlTask);
        urlsToCrawl.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUncrawled(exec.shutdownNow());
            // 作用?
            if (exec.awaitTermination(TIMEOUT, UNIT)) {
                saveUncrawled(exec.getCancelledTasks());
            }
        } finally {
            exec = null;
        }
    }

    protected abstract List<URL> processPage(URL url);

    // 保存尚未执行的抓取任务
    private void saveUncrawled(List<Runnable> unCrawledTask) {
        for (Runnable task : unCrawledTask) {
            urlsToCrawl.add(((CrawlTask) task).getPage());
        }
    }

    private void submitCrawlTask(URL url) {
        exec.execute(new CrawlTask(url));
    }

    private class CrawlTask implements Runnable {
        private final URL url;


        public CrawlTask(URL url) {
            this.url = url;
        }

        // 这个计数器没有使用上
        private int count = 1;

        // 判断该任务是否已经被抓取过
        boolean alreadyCrawled() {
            return seen.putIfAbsent(url, true) != null;
        }

        // 将已经抓取的任务移除队列
        void makeUncrawled() {
            seen.remove(url);
            System.out.printf("marking %s uncrawled %n", url);
        }

        @Override
        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                submitCrawlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
