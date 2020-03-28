package chapter1;

import java.math.BigInteger;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.ThreadSafe;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description 一个线程安全的 Servlet 因为这个类不存在状态（实力域，静态域） 只是在方法内对参数进行处理
 * @date 2020/3/20 2:39 下午
 */

@ThreadSafe
public class StatelessFactorizer extends GenericServlet implements Servlet {


    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {

    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }


}
