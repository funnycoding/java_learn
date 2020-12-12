package chapter1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;

public class UnsafeCountingFactorizerTest {
    /**
     * 启动 1000 个线程同时访问 UnsafeCountingFactorizer ，输出最后的计数器的值
     */
    private UnsafeCountingFactorizer servlet;
    HttpServletRequest request;
    HttpServletResponse response;
    UnsafeCountingFactorizerTest test;

    @Before
    public void setUp() {
        test = new UnsafeCountingFactorizerTest();
        test.request = mock(HttpServletRequest.class);
        test.servlet = new UnsafeCountingFactorizer();
        test.response = mock(HttpServletResponse.class);
    }

    public void testService() {
        servlet.service(request, response);
    }

    @Test
    public void testCounting() throws InterruptedException {
        Thread t = new Thread(test::testService);
        Thread t2 = new Thread(test::testService);
        t.start();
        t2.start();
        t2.join();
        t.join();
        assertEquals(2000000, test.servlet.getCount());
    }
}