package collections;

import java.util.ArrayList;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 3:38 下午
 */

class GrannySmith extends Apple {
}

class Gala extends Apple {
}

class Fuji extends Apple {
}

class Braeburn extends Apple {
}

public class GenericsAndUpcastring {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Gala());
        apples.add(new Braeburn());
        for (Apple apple : apples) {
            System.out.println(apple);
        }
    }

}
