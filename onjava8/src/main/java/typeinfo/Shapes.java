package typeinfo;

import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 5:12 下午
 */

// 最顶层的抽象基类，定义一个通用 draw 方法。打印自己本身，并将 toString 设置为抽象方法让子类自己实现。
// typeinfo/Shapes.java
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}


class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}


public class Shapes {
    public static void main(String[] args) {
        Stream<Shape> shapeStream = Stream.of(new Circle(), new Square(), new Triangle());
        shapeStream.forEach(System.out::println);
    }
}
