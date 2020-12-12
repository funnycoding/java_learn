package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:51 下午
 */

public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
