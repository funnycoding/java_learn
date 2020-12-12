package polymorphism;


/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/8 11:23 下午
 */

class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
}

class Brass extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
}

public class Music2 {
    public static void tune(Wind wind) {
        wind.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed stringed) {
        stringed.play(Note.MIDDLE_C);
    }

    public static void tune(Brass brass) {
        brass.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        Stringed stringed = new Stringed();
        Brass brass = new Brass();
        tune(wind);
        tune(stringed);
        tune(brass);
        System.out.println("----------");
        Music.tune(wind);
        Music.tune(stringed);
        Music.tune(brass);
    }
}


