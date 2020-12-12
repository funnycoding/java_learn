package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:52 下午
 */

public class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input; // Dummy processing 哑处理 但是这里没看懂，这里的处理和父类一毛一样干嘛还特地继承一下
    }
}
