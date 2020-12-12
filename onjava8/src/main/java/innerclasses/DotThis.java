package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 10:25 下午
 */

public class DotThis {
    void f() {
        System.out.println("DotTHis.f()");
    }

    public class Inner {

        // 获取外围类的对象
        public DotThis getOuterInstance() {
            return DotThis.this;
        }
    }

    // 获取内部类对象
    public Inner getInnerInstance() {
        return new Inner();
    }

    public static void main(String[] args) {
        // 创建外围类对象实例
        DotThis dt = new DotThis();

        // 获取内部类对象实例
        Inner innerInstance = dt.getInnerInstance();

        // 内部类实例获取外围类对象并调用外围类方法
        innerInstance.getOuterInstance().f();
    }
}
