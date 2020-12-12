package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 2:49 下午
 */

public interface Operations {
    void execute();


    static void runOps(Operations... ops) {
        for (Operations o : ops) {
            o.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }

}

