package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 11:14 上午
 */
// generics/InheritBounds.java
class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

// 限制了 T 是 HasColor 的子类
class WithColor2<T extends HasColor> extends HoldItem<T> {

    public WithColor2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class WithColorCOord2<T extends Coord & HasColor> extends WithColor2<T> {

    public WithColorCOord2(T item) {
        super(item);
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
}

class Solid2<T extends Coord & HasColor & Weight> extends WithColorCOord2<T> {
    public Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}


public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
