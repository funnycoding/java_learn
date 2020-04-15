package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 1:34 下午
 */

// Requesting travel quotes under a time budget
// 使用 invokeAll 来获取一组报价，这个类的设计非常严谨
public class TimeBudget {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    // 获取报价的方法 在这里调用 QuoteTask 中的方法
    public List<TravelQuote> getRankedTravelQuotes(TravelInfo travelInfo, Set<TravelCompany> companies,
            Comparator<TravelQuote> ranking, long time, TimeUnit unit) throws InterruptedException {
        final List<QuoteTask> tasks = new ArrayList<>();

        // 轮询调用每个旅行社指定 TravelInfo 的报价
        for (TravelCompany company : companies) {
            tasks.add(new QuoteTask(company, travelInfo));
        }

        // 通知任务执行框架开始这一组任务，并获取其 Future
        final List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, unit);

        // 用来保存真正获取到的报价信息 其数量与获取报价任务的数量相等
        final List<TravelQuote> quotes = new ArrayList<>(tasks.size());

        // 获取任务的迭代器
        final Iterator<QuoteTask> taskIter = tasks.iterator();
        // 遍历 Future 获取其任务执行完成的信息
        for (Future<TravelQuote> f : futures) {
            final QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
                // 发生异常时 ，在 task列表中 增加一个 获取失败的报价类
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
                // 收集因任务关闭导致获取报价失败的类
                quotes.add(task.getTimeoutQuote(e));
            }
        }
        // 排序
        Collections.sort(quotes, ranking);
        return quotes;
    }

}

// 获取报价类的具体实现
class QuoteTask implements Callable<TravelQuote> {
    // 旅行社
    private final TravelCompany company;
    // 不同航线
    private final TravelInfo info;

    public QuoteTask(TravelCompany company, TravelInfo info) {
        this.company = company;
        this.info = info;
    }

    // 获取失败的报价信息
    TravelQuote getFailureQuote(Throwable t) {
        return null;
    }

    // 获取超时的报价信息
    TravelQuote getTimeoutQuote(CancellationException e) {
        return null;
    }

    @Override
    public TravelQuote call() throws Exception {
        // 调用旅行社的获取具体航线信息报价的方法
        return company.solicitQuote(info);
    }
}

// 代表不同旅行社的类
interface TravelCompany {
    // 返回具体报价信息
    TravelQuote solicitQuote(TravelInfo travelInfo) throws Exception;
}

// 报价
interface TravelQuote {

}

// 不同航线的信息
interface TravelInfo {

}