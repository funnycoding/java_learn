package collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 4:06 下午
 */
class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());
        snow1.add(new Heavy()); // Exception

        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush());


    }
}
