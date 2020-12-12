package polymorphism;

import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/7 7:25 下午
 */
@Slf4j
class WaterSource {
    private String s;

    public WaterSource() {
        System.out.println("WaterSource()");
        log.info("S:{}",s);
        s = "Constructed";
        log.info("S:{}", s);
    }

    @Override
    public String toString() {
      return s;
    }
}

public class SprinklerSystem {
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();

    private int i;
    private float f;

    @Override
    public String toString() {
        return new StringJoiner(", ", SprinklerSystem.class.getSimpleName() + "[", "]")
                .add("value1='" + value1 + "'")
                .add("value2='" + value2 + "'")
                .add("value3='" + value3 + "'")
                .add("value4='" + value4 + "'")
                .add("source=" + source)
                .add("i=" + i)
                .add("f=" + f)
                .toString();
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}
