package chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试单例类并发创建场景
 */
public class LazyInitRaceTest {
    LazyInitRace lazyInitRace;

    @Before
    public void setUp() {
        lazyInitRace = new LazyInitRace();
    }

    @Test
    public void testLazyInit() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> lazyInitRace.getInstance());
            t.start();
        }
        Assert.assertEquals(1,lazyInitRace.getCount());
        System.out.println(lazyInitRace.getCount());
    }
}