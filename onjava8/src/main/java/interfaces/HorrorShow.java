package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 5:09 下午
 */

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

/**
 * 继承了2个接口 吸血鬼 多了喝血的功能
 */
interface Vampire extends DangerousMonster,Lethal{
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

public class HorrorShow {
    static void u(Monster monster) {
        monster.menace();
    }

    static void v(DangerousMonster dangerousMonster) {
        dangerousMonster.menace();
        dangerousMonster.destroy();
    }
    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DragonZilla dragonZilla = new DragonZilla();
        u(dragonZilla);
        v(dragonZilla);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
