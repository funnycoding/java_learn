package test;

import java.sql.Time;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/5/31 9:00 下午
 */

public class MovieTest {

    private volatile int id = 0;



    public static void main(String[] args) {
        int id = 0;

        OrdinaryMovie ordinaryMovie1 = new OrdinaryMovie("1", null, 1, 0.1,1, id);
        id++;
        OrdinaryMovie ordinaryMovie2 = new OrdinaryMovie("1", null, 1, 0.1, 1,id);
        System.out.println(ordinaryMovie1.getId());
        System.out.println(ordinaryMovie2.getId());
    }

    public synchronized Movie initMovie(String name, Time startTime) {
        OrdinaryMovie ordinaryMovie1 = new OrdinaryMovie("1", null, 1, 0.1,1, id);
        id++;
        return ordinaryMovie1;
    }
}
