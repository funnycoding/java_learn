package generics;

import java.util.Date;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 3:52 下午
 */

// generics/Mixins.java
// 返回时间戳功能
interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

// 返回序列号功能
interface SerialNumbered {
    long getSerialNumbered();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumbered() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}


// 同时实现2种接口，并初始化接口的对应实现类并调用接口的功能就实现了功能的整合。
class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumbered() {
        return serialNumbered.getSerialNumbered();
    }
}


public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("Test String 1");
        mixin2.set("Test String 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumbered());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumbered());

    }
}
