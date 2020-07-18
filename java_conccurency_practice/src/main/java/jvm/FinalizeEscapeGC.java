package jvm;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 *
 * @date 2020/7/18 6:37 下午
 */

/**
 * 对象可以在被 GC 时 自我拯救
 * 这种自救机会只有1次，因为一个对象的finalize 方法最多被系统调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("是的，我还活着！");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法被调用了！");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        System.out.println("SAVE_HOOK 第一次被设置null然后调用系统GC");
        SAVE_HOOK = null;
        // 此时 finalize 方法被 JVM 调用，引用重新赋值，SAVE_HOOK 拯救了自己并没有被GC掉
        System.gc();
        Thread.sleep(500);
        System.out.println("查询 SAVE_HOOK 生命状态");
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("SAVE_HOOK 已经消亡！");
        }
        System.out.println("SAVE_HOOK 再次被设置null然后调用系统GC");
        // 再次将对象引用置为 null 然后调用 gc 方法
        SAVE_HOOK = null;
        System.gc();
        // Finalizer 方法优先级很低，暂停0.5秒等待方法被调用
        Thread.sleep(500);
        System.out.println("查询 SAVE_HOOK 生命状态");
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("SAVE_HOOK 已经消亡！");
        }
    }
}
