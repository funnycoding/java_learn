package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 3:17 下午
 */

// generics/ThrowGenericException.java

interface Processor<T, E extends Exception> {
    // 可以使用 throws 抛出 泛型类型的异常
    void process(List<T> resultCollection) throws E;
}

// Processor 的代理类，运行 Processor的方法
class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        // 调用每个 Processor 的 process 方法
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

// 自己定义的异常类
class Failure1 extends Exception {
}

// Processor 的具体实现类
class Processor1 implements Processor<String, Failure1> {

    static int count = 3;

    @Override
    public void process(List<String> resultCollection) throws Failure1 {
        if (count-- > 1) {
            resultCollection.add("Hep!");
        } else {
            resultCollection.add("Ho!");
        }
        // 但是感觉这个循环进不去啊
        if (count < 0) {
            throw new Failure1();
        }

    }
}


// 第二个自定义异常
class Failure2 extends Exception {
}

class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollection) throws Failure2 {
        if (count-- == 0) {
            resultCollection.add(47);
        } else {
            resultCollection.add(11);
        }
        // 这时会抛出异常
        if (count < 0) {
            throw new Failure2();
        }
    }
}


public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        }

        ProcessRunner<Integer, Failure2> runner2 =
                new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }
    }
}
