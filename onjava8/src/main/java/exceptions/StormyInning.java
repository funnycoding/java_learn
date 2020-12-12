package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 9:57 下午
 */

// Overridden methods can throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions
// StormyInning.java
class BaseballException extends Exception {
}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

abstract class Inning {
    Inning() throws BaseballException {

    }

    public void event() throws BaseballException {
        // 实际不会抛出任何异常
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() { // 抛出运行时异常

    }
}

class PopFoul extends Foul {
}

class StormException extends Exception {
}

class RainedOut extends StormException {

}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}


public class StormyInning extends Inning implements Storm {
    // 子类的构造器可以抛出新的异常类型，但是必须包含父类构造器所抛出的异常
    StormyInning() throws BaseballException, RainedOut {
    }

    public StormyInning(String s)
            throws BaseballException {
    }

    // 普通方法必须符合基类的异常
    //public void walk() throws PopFoul {} // 这里覆写基类的 walk() 方法，但是基类没有抛出异常，则子类不能抛出异常，否则编译器会父类并没有抛出该异常
    // 接口不能向基类的现有方法中方法添加异常：
    // 这里接口和父类中都包含 event 方法，接口抛出 RainedOut 异常，而父类没有，所以子类不能抛出 RainedOut异常
    // 这里 event 在子类中不能抛出任何异常，因为基类和接口中抛出的异常不一致
    @Override
    public void event() {
    }



    @Override
    public void atBat() throws PopFoul {
        throw new PopFoul();
    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rain out");
        } catch (BaseballException e) {
            System.out.println("Generic Baseball Exception");
        }

        try {
            // 当多态发生时，需要补货具体对象构造时可能抛出的异常
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
