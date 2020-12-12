package chapter14.bounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description Shows an animated bouncing ball
 * @date 2020/3/28 7:22 下午
 */

// 展示一个球弹跳的类
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            System.out.println("弹跳球 死大头！");
            JFrame frame = new BounceFrame();
            // 设置一个默认的
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        });
    }
}

/**
 * 承载 小球和按钮的画布 Frame
 */
class BounceFrame extends JFrame {
    private BallCompoent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrame() {
        setTitle("单线程的弹弹球！");
        comp = new BallCompoent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "开始", event -> addBall());
        addButton(buttonPanel, "结束", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * 添加一个按钮到容器中
     *
     * 创建按钮 -> 容器添加按钮 -> 按钮绑定监听事件
     *
     * @param c 容器
     * @param title 按钮的标题
     * @param listener 事件监听器
     */
    public void addButton(Container c, String title, ActionListener listener) {

        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 将小球添加到 Component 中
     */
    public void addBall() {
        try {
            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 0; i < STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println("发生 Interrupted 异常！");
        }
    }
}