package typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 8:48 下午
 */

// SnowRemovalRobot.java
public class SnowRemovalRobot implements Robot {

    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "我是一个扫雪机器人，B-ling，B-long";
    }

    private List<Operation> ops =
            Arrays.asList(
                    new Operation(
                            () -> name + " can shovel snow",
                            () -> System.out.println(name + " shoveling snow")),
                    new Operation(
                            () -> name + "can ship ice",
                            () -> System.out.println(name + " chipping ice")),
                    new Operation(
                            () -> name + " can clear the roof",
                            () -> System.out.println(name + " clearing roof")));


    @Override
    public List<Operation> operations() {
        return ops;
    }

    public static void main(String[] args) {
        Robot.test(new SnowRemovalRobot("Slusher"));
    }
}
