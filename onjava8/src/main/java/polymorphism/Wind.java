package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/8 11:01 下午
 */

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}

public class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }
}
