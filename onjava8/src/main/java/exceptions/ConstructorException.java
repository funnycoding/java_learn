package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 4:06 下午
 */

// ConstructorException.java
class CE extends Exception {

}
// 继承的类实现了 AutoCloseable接口
class SecondExcept extends Reporter {
    public SecondExcept() throws CE{
        super();
        throw new CE();
    }
}

public class ConstructorException {
    public static void main(String[] args) {
        try (
                final First first = new First();
                SecondExcept s = new SecondExcept();
                Second s2 = new Second();
        ) {
            System.out.println("In body");
        } catch (CE ce) {
            System.out.println("Caught: " + ce);
        }
    }
}
