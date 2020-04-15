package chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/4/14 10:24 上午
 */

// 串行渲染页面元素
public abstract class SingleThreadRenderer {
    void renderPage(CharSequence source) {
        // 先渲染文字
        renderText(source);
        // 定义页面图像引用
        List<ImageData> imageData = new ArrayList<>();
        // 通过source分析出其包含的图像信息 并将其添加到之前定义的 imageData 中
        for (ImageInfo imageInfo : scanForImageInfo(source)) {
            imageData.add(imageInfo.downloadImage());
        }
        // 渲染页面图片
        for (ImageData data : imageData) {
            renderImage(data);
        }

    }


    // 代表页面中图像元素的数据类
    interface ImageData {

    }

    // 承载图像信息的接口，其实现了下载图像的方法
    interface ImageInfo {

        ImageData downloadImage();
    }
    
    abstract List<ImageInfo> scanForImageInfo(CharSequence source);

    abstract void renderImage(ImageData data);

    abstract void renderText(CharSequence source);
}
