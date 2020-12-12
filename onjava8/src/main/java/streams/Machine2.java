package streams;

import java.util.Arrays;
import interfaces.Operations;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/21 3:01 下午
 */

public class Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new Operations[]{
                () -> Operations.show("Bing"),
                () -> Operations.show("Crack"),
                () -> Operations.show("Twist"),
                () -> Operations.show("Pop"),
        }).forEach(Operations::execute);
    }
}
