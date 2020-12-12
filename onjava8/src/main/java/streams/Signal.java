package streams;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 3:30 下午
 */
// streams/Signal.java`
public class Signal {
    private final String msg;

    public Signal(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Signal(" + msg + ")";
    }

    static Random rand = new Random(47);

    public static Signal morse() {
        switch (rand.nextInt(4)) {
            case 1:
                return new Signal("dot");

            case 2:
                return new Signal("dash");
            default:
                return null;
        }
    }

    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse)
                .map(signal -> Optional.ofNullable(signal));
    }
}
