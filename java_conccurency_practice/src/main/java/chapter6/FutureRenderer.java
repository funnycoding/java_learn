package chapter6;

import chapter5.LaunderThrowable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 11:18 上午
 */

// 使用 Future 等待下载图像任务的完成
public abstract class FutureRenderer {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        // 创建一个 Callable 开启一个线程专门下载图片
        Callable<List<ImageData>> task = () -> {
            final List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos) {
                result.add(imageInfo.downloadImage());
            }
            return result;
        };
        // 提交这个 Callable 到 Executor 中，获得一个返回的 Future
        final Future<List<ImageData>> future = executor.submit(task);

        // 渲染文字
        renderText(source);

        try {
            // 开始获取下载图片的结果
            final List<ImageData> imageData = future.get();
            // 渲染图片
            imageData.forEach(this::renderImage);
        } catch (InterruptedException e) {
            // 重新声明线程的中断状态
            Thread.currentThread().interrupt();
            // 此时这个 Future 的结果已经不需要了，所以关闭这个任务
            future.cancel(true);
        } catch (ExecutionException e) {
            // 抛出异常
            throw LaunderThrowable.launderThrowable(e);
        }
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence source);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData imageData);
}
