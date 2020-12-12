package chapter14.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/28 6:54 下午
 */

// 小球本体 具有大小，处于组件中的坐标位置， 移动功能
public class Ball {
    // 使用的静态不可变域来保存球的尺寸
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;

    private double x = 0;
    private double y = 0;

    private double dx = 1;
    private double dy = 1;

    /**
     * 将小球移动到下一个位置，如果碰到边缘，则反向运动
     *
     * @param bounds
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;

        // 最小边界
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        // 最大边界
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }

        // 下边界
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }

        // 上边界
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Get the shape of the ball at its current position 获取小球当前位置的形状
     *
     * @return
     */
    public Ellipse2D getShape() {
        return new Double(x, y, XSIZE, YSIZE);
    }
}
