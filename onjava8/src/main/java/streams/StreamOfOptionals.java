package streams;

import java.util.Optional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 3:37 下午
 */

public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("-----------");

        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
