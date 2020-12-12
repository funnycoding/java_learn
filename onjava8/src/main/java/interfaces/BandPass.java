package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:57 下午
 */

public class BandPass extends Filter{
    double lowCutoff,highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
