package chapter14.bounceThread;

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
 * @description
 * @date 2020/3/28 8:36 下午
 */
// 单独渲染小球运行的线程
public class BouceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("这是一个「多线程」弹弹球！");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The Frame with panel and buttons
 */
class BounceFrame extends JFrame {
    private BallCompoent comp;
    private static final int STEPS = 1000;
    public static final int DELAY = 5;


    public BounceFrame() {
        comp = new BallCompoent();
        // 将 compoent 添加到画布中并渲染出来
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        // 添加小球事情button
        addButton(buttonPanel, "走你！", evenet -> addBall());
        addButton(buttonPanel, "结束！", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        // 相当于最后打包整理一下
        pack();
    }

    /**
     * 向 Frame 中添加 Button
     *
     * @param c
     * @param title
     * @param listener
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the canvas and starts a thread to make it bounce
     *
     * 添加一个小球到画布中并且使用独立的线程渲染它
     */
    public void addBall() {
        Ball ball = new Ball();
        // 添加到组件中
        comp.add(ball);

        // 单独渲染小球的线程
        Runnable r = () -> {
            // 打印当前线程的名称
            System.out.println("单独渲染小球的线程名称：" + Thread.currentThread().getName());
            try {
                for (int i = 0; i < STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);

                }
            } catch (InterruptedException e) {
                System.out.println("异常发生了");
            }
        };

        System.out.println("启动一个新线程来作为小球的渲染画布！");
        Thread t = new Thread(r);
        t.start();
    }
}
