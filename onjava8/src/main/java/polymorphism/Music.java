package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/8 11:03 下午
 */

public class Music {
    public static void tune(Instrument instrument) {
    instrument.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        tune(wind);
    }
}
