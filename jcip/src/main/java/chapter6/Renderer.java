package chapter6;

import chapter5.LaunderThrowable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 12:07 下午
 */
// 为每个图片分配一个线程进行下载，并且当其下载完成后立即进行渲染
public abstract class Renderer {
    private final ExecutorService executor;

    // 通过传入 ExecutorService 获得不同的特性
    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {
        final List<ImageInfo> info = scanForImageInfo(source);
        // 初始化 ExecutorCompletionService
        final ExecutorCompletionService<ImageData> completionService =
                new ExecutorCompletionService<>(executor);
        // 为每个图片分配一个线程进行下载
        for (final ImageInfo imageInfo : info) {
            completionService.submit(imageInfo::downloadIamge);
        }
        // 渲染页面文字
        renderText(source);

        try {
            for (int t = 0; t < info.size(); t++) {
                // 获取下载任务关联的 Future
                final Future<ImageData> f = completionService.take();
                // 获取下载任务的结果 ——> ImageData
                final ImageData imageData = f.get();
                // 渲染页面图片
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launderThrowable(e);
        }
    }


    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadIamge();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
