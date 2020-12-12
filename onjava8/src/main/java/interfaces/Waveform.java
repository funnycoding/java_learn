package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:49 下午
 */

public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}


