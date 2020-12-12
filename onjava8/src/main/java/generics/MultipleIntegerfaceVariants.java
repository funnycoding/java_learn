package generics;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 8:56 下午
 */

public class MultipleIntegerfaceVariants {
    interface Payble<T>{}

    class Employee implements Payble {

    }

    class Hourly extends Employee implements Payble {

    }
}
