package typeinfo;

import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 8:38 下午
 */
// Robot.java
public interface Robot {
    String name();

    String model();

    List<Operation> operations();

    static void test(Robot r) {
        if (r instanceof Null) {
            System.out.println("[Null Robot]");
        }
        System.out.println("RobotName: " + r.name());
        System.out.println("RobotModel: " + r.model());

        for (Operation o : r.operations()) {
            System.out.println(o.description.get());
            o.command.run();
        }
    }
}
