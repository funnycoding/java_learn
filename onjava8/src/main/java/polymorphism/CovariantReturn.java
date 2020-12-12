package polymorphism;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/9 10:02 下午
 */

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}


class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    // 这里返回子类型
    @Override
    Wheat process() {
        return new Wheat();
    }
}


public class CovariantReturn {
    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain g = mill.process();
        System.out.println(g);

        mill = new WheatMill();
        g = mill.process();
        System.out.println(g);
    }
}
