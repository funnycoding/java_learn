package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 7:32 下午
 */

public class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    // 两个改变状态的方法
    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    // 打印 state 的状态
    @Override
    public String toString() {
        return state ? "on" : "off";
    }

}
