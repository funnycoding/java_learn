package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 2:55 下午
 */
// ListMaker.java
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> strMaker = new ListMaker<>();
        List<String> strings = strMaker.create();
    }
}
