package generics;

import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 11:30 上午
 */

// generics/EpicBattle.java
// Bounds in Java generics
interface SuperPower {

}

// 镭射眼
interface XRayVIsion extends SuperPower {
    // 穿墙
    void seeThroughWalls();
}

// 顺风耳
interface SuperHearing extends SuperPower {
    // 窃听
    void hearSubtleNoises();
}

// 狗鼻子
interface SuperSmell extends SuperPower {
    // 追踪
    void trackBySmell();
}

// 超英必须具有上面的超级能力
class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}

// 超级忍犬
class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    public CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}


// 超级听力和嗅觉的具体实现类
class SuperHearSmell implements SuperHearing, SuperSmell {

    @Override
    public void hearSubtleNoises() {
        System.out.println("战术目镜启动！");
    }

    @Override
    public void trackBySmell() {
        System.out.println("超级嗅觉！");
    }
}


class DogPerson extends CanineHero<SuperHearSmell> {

    public DogPerson() {
        super(new SuperHearSmell());
    }
}


// 史诗对决，牛逼了
public class EpicBattle {
    // 使用 extends 通配符限制 泛型边界

    static <POWER extends SuperHearing> void userSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();

    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        System.out.println("----------");
        userSuperHearing(dogPerson);
        superFind(dogPerson);

        List<? extends SuperHearing> audioPeople;
        // But you can't do this: 不能这样做
        // List<? extends SuperHearing & SuperSmell> dogPs;
    }

}
