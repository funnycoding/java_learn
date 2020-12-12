package typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 4:16 下午
 */

// RegisteredFactories.java
// 继承函数式接口，提供一个协变类型的 get() 方法
class Part implements Supplier<Part> {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Supplier<? extends Part>> prototypes =
            Arrays.asList(
                    new FuelFilter(),
                    new AirFilter(),
                    new CabinAirFilter(),
                    new OilFilter(),
                    new FanBelt(),
                    new PowerSteeringBelt(),
                    new GeneratorBelt()
            );

    private static Random rand = new Random(47);

    public Part get() {
        int n = rand.nextInt(prototypes.size());
        return prototypes.get(n).get();
    }
}

class Filter extends Part {
}


class FuelFilter extends Filter {
    @Override
    public FuelFilter get() {
        return new FuelFilter();
    }
}


class AirFilter extends Filter {
    @Override
    public AirFilter get() {
        return new AirFilter();
    }
}


class CabinAirFilter extends Filter {
    @Override
    public CabinAirFilter get() {
        return new CabinAirFilter();
    }
}

class OilFilter extends Filter {
    @Override
    public OilFilter get() {
        return new OilFilter();
    }
}

class Belt extends Part {
}


class FanBelt extends Belt {
    @Override
    public FanBelt get() {
        return new FanBelt();
    }
}

class GeneratorBelt extends Belt {
    @Override
    public GeneratorBelt get() {
        return new GeneratorBelt();
    }
}

class PowerSteeringBelt extends Belt {
    @Override
    public PowerSteeringBelt get() {
        return new PowerSteeringBelt();
    }
}


public class RegisteredFactories {
    public static void main(String[] args) {
        Stream.generate(new Part())
                .limit(10)
                .forEach(System.out::println);
    }
}
