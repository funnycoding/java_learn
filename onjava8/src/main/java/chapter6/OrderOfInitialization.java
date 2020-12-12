package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description 成员变量的初始化在构造器调用之前，不管成员变量在构造器之前还是周（代码位置）
 * @date 2020/9/8 2:31 下午
 */

class Window{
    public Window(int marker) {
        System.out.println("Window(" +marker+")");
    }
}

class House{
    Window w1 = new Window(1); // 成员变量位于构造器之前

    public House() {
        System.out.println("House 构造函数被调用了");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);


    void f() {
        System.out.println("函数 f 被调用了");
    }

    // 成员变量定义的位置在最后，处于它之前的构造函数仍然可以访问到 w3 引用
    Window w3 = new Window(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}
