package generics;

import java.awt.Color;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 11:03 上午
 */

// generics/BasicBounds.java
interface HasColor {
    java.awt.Color getColor();
}

// 边界限制泛型元素实现了 HasColor 所以 T 可以有 getColor() 方法
class WithColor<T extends HasColor> {
    T item;

    WithColor(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class Coord {
    public int x, y, z;
}

// This fails. Class must be first, then interfaces:
// class WithColorCoord<T extends HasColor & Coord> {

// Multiple bounds: 多重限制 泛型元素必须继承 Coord 并且实现 HasColor 接口
class WithColorCoord<T extends Coord & HasColor> {
    T item;

    public WithColorCoord(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    // 继承 Coord 的字段
    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}


// As with inheritance, you can have only one
// concrete class but multiple interfaces: 继承 Coord 实现 HasColor 和 Weight 接口。 这里把类放在最前面
class Solid<T extends Coord & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Coord implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 10;
    }
}

public class BasicBounds<T extends HasColor> {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        // 这里调用的都是 Bounded 类的方法
        solid.color();
        solid.getY();
        solid.weight();
    }
}
