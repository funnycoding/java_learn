package typeinfo;

import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 8:40 下午
 */
// typeinfo/Operation.java
public class Operation {
    public final Supplier<String> description;
    public final Runnable command;

    public Operation(Supplier<String> descr, Runnable cmd) {
        description = descr;
        command = cmd;
    }
}
