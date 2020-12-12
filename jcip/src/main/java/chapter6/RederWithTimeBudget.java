package chapter6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 1:14 下午
 */
// 使用有时限的任务来放弃超时的失效 Task
public class RederWithTimeBudget {
    // 广告信息，初始化时使用默认广告信息
    private static final Ad DEFAULT_AD = new Ad();
    // 超时时间
    private static final long TIME_BUDGET = 1000;
    // 初始化任务执行框架
    private static final ExecutorService exec = Executors.newCachedThreadPool();


    // 这里没有处理被中断的异常，而是将其抛给了调用者进行处理
    Page renderPageWithAd() throws InterruptedException {
        // 结束时间
        final long endNanos = System.nanoTime() + TIME_BUDGET;
        // 提交一个获取广告的任务到任务执行框架中
        final Future<Ad> f = exec.submit(new FetchAdTask());
        // Render the page while waiting for the ad 在等待获取广告的同事，渲染这个页面
        final Page page = renderPageBody();
        Ad ad;
        try {
            // Only wait for the remaining time budget
            // 获取任务执行时间，如果超时则直接抛弃任务 ，如果获取成功则将其赋值给之前定义的广告引用
            final long timeLeft = endNanos - System.nanoTime();
            ad = f.get(timeLeft, TimeUnit.NANOSECONDS);
        } catch (ExecutionException e) {
            // 发生异常时，将广告信息设置为默认信息
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {
            // 如果获取广告的任务超时，不仅将广告设置为默认信息，同时关闭这个获取广告的任务
            ad = DEFAULT_AD;
            f.cancel(true);
        }
        page.setAd(ad);
        return page;
    }

    // 渲染页面的方法
    Page renderPageBody() {
        return new Page();
    }


    // 页面信息类
    static class Page {
        // 设置页面内的广告内容
        public void setAd(Ad ad) {

        }
    }

    // 获取广告的行为
    static class FetchAdTask implements Callable<Ad> {
        @Override
        public Ad call() throws Exception {
            return new Ad();
        }
    }

    // 默认广告信息
    static class Ad {
    }
}
