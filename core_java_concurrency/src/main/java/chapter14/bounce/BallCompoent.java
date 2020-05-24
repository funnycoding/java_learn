package chapter14.bounce;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/28 7:01 下午
 */

// 保存小球的容器，程序中可以同时存在多个小球
public class BallCompoent extends JPanel {
    // 小球画布的宽高
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private List<Ball> balls = new ArrayList<>();

    /**
     * 向组件 Component 中添加一个小球
     *
     * @param ball
     */
    public void add(Ball ball) {
        System.out.println("添加一个小球！");
        balls.add(ball);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // erase background 擦除背景
        // 将 Graphis 转为 Graphic 2D
        Graphics2D g2 = (Graphics2D) g;

        // 将小球放入画布
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    // 给窗口提供一个初始大小
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
