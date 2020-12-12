package generics.decorator;

import java.util.Date;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 6:23 下午
 */

// generics/decorator/Decoration.java
// 用装饰器模式重写混型继承类
// 后面的代码既视感很强，就是 Java 的 旧的 I/O 类就是这样的，构造一个对象需要套好几个对象来进行功能的叠加。
class Basic {
    private String value;

    public String get() {
        return value;
    }

    public void set(String value) {
        this.value = value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    // 这样重写跟 super.get() 有啥区别？ 不都是调用父类的方法么？ 哦 区别是 这里的 Basic 可以动态改变
    @Override
    public String get() {
        return basic.get();
    }

    @Override
    public void set(String value) {
        basic.set(value);
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        this.timeStamp = new Date().getTime();
    }

    // 这里又多了一个独有的方法
    public long getStamp() {
        return timeStamp;
    }
}

// Decorator 相当于一个基础功能，然后不同的子功能再去继承 Decorator 包装类
class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        //- t2.getSerialNumber(); // Not available 因为 TimeStamp 类中没有获取序列号的方法
        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(
                new TimeStamped(new Basic()));
        //- s2.getStamp(); // Not available 同理，获取序列号的对象也没有获取时间戳的方法
    }

}
