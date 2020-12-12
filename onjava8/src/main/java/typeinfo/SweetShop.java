package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 6:29 下午
 */
// typeinfo/SweetShop.java
// 检查类加载器工作方式
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}


public class SweetShop {
    public static void main(String[] args) {
        System.out.println("进入 main() 方法了");
        new Candy();
        new Candy(); // 可以看到静态代码块只在第一次类加载的时候被执行

        System.out.println("创建 Candy 对象之后");
        try {
            // 这里要正确的加载只能带上包名 后面作者再次使用的时候也加上了包名，我倾向于这是作者的失误
            Class.forName("typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After Create Cookie");

    }
}
