package reuse;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/26 12:21 下午
 */
// SpaceShipDelegation.java
public class SpaceShipDelegation {
    private String name;
    // 创建一个控制模块的实例对象
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    // 委托的方法: 在委托类中调用控制模块的方法，相当于做了2次封装
    public void back(int velocity) {
        controls.back(velocity);
    }
    public void down(int velocity) {
        controls.down(velocity);
    }
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    public void left(int velocity) {
        controls.left(velocity);
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }


}
