package collections;

import java.util.Map;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 11:39 下午
 */

public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }
}

