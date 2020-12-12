package reuse;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/26 11:56 上午
 */

// Detergent.java
class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" 父类dilute()");
    }

    public void apply() {
        append(" 父类apply()");
    }

    public void scrub() {
        append(" 父类scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser {
    // 改变父类方法的行为
    @Override
    public void scrub() {
        append(" 子类Detergent.scrub()");
        super.scrub();
    }

    // 子类新加方法
    public void foam() {
        append(" 子类foam()");
    }

    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class args:"+ Arrays.toString(args) );
        Cleanser.main(args);
    }
}
