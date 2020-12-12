package reuse;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/26 12:05 下午
 */
// Chess.java

class Game {
    Game(int i) {
        System.out.println("Game constructor 顶层父类带参构造函数");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame construc 一级子类带参构造函数，先调用父类的带参构造函数");
    }
}

public class Chess extends BoardGame{
    Chess() {
        super(11);
        System.out.println("Chess 二级子类的无参构造函数，但是要先调用父类的带参构造函数");
    }

    public static void main(String[] args) {
        new Chess();
    }
}
