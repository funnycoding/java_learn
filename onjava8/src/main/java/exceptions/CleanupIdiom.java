package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 2:59 下午
 */
// exceptions/CleanupIdiom.java
// 清理对象必须在一个 try-finally 语句块中

class NeedsCleanUp { // 构造方法不能失败
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("需要清理的对象: " + id + " 被清理");
    }
}

class ConstructionException extends Exception {
}

class NeedsCleanUp2 extends NeedsCleanUp {
    // 构造方法可以失败
    public NeedsCleanUp2() throws ConstructionException {
    }
}


public class CleanupIdiom {
    public static void main(String[] args) {
        //[1]
        NeedsCleanUp nc1 = new NeedsCleanUp();
        try {
            //针对 nc1 的业务代码
        } finally {
            // 对资源进行清理
            nc1.dispose();
        }

        //[2]
        //如果构造函数不能失败，你可以对对象分组
        NeedsCleanUp nc2 = new NeedsCleanUp();
        NeedsCleanUp nc3 = new NeedsCleanUp();
        try {
            //...
        } finally { // 反向清理，后构建的先被清理，因为可能有依赖关系
            nc3.dispose();
            nc2.dispose();
        }

        //[3]
        // 如果构造对象时可能失败，必须针对每个对象的构造进行保护
        try {
            NeedsCleanUp2 nc4 = new NeedsCleanUp2();

            try {
                NeedsCleanUp2 nc5 = new NeedsCleanUp2();
                try {
                    //...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) { // nc5 抛出的异常
                System.out.println(e);
            } finally {
                nc4.dispose();
            }

        } catch (ConstructionException e) { // nc4 抛出的异常
            System.out.println(e);
        }
    }
}
