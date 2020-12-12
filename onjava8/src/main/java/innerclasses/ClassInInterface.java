package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 3:19 下午
 */



public interface ClassInInterface {
    void howdy();

    // 接口内嵌套的静态内部类
    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("接口内嵌套静态内部类输出的 Howdy!");
        }
    }

    static void main(String[] args) {
        new Test().howdy();
    }

}
