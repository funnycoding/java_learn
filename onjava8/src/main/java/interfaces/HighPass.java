package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:53 下午
 */

public class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
