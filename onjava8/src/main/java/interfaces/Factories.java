package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 11:49 下午
 */

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Service1 implements Service {

    Service1() {
    } // 包访问权限

    @Override
    public void method1() {
        System.out.println("Service1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Service1 method2");
    }
}

class Service1Factory implements ServiceFactory {


    // 获取 Service1 对象
    @Override
    public Service getService() {
        return new Service1();
    }
}

class Service2 implements Service {
    Service2() {} // Package access

    @Override
    public void method1() {
        System.out.println("Service2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Service2 method2");
    }
}

// Service2工厂
class Service2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Service2();
    }
}


public class Factories {
    // 将工厂对象放入 获取其生成的 Service对象并调用服务
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        Factories.serviceConsumer(new Service1Factory());
        Factories.serviceConsumer(new Service2Factory());
    }
}
