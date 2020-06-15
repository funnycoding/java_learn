package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/6/3 6:34 下午
 */

// 代替了在 web.xml 中进行配置的方式
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloForm() {
        super(); // 但是父类这里啥也没干啊? 为什么要这样写?
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置响应内容类型
            resp.setContentType("text/html;charset=UTF-8");

        // 输出
        PrintWriter out = resp.getWriter();
        String title = "使用 Get 方法读取表单数据的 Servlet";

        // 处理中文字符集
        String name = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");

        String docType = "<!DOCTYPE html> \n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul> \n" +
                "  <li><b> 站点名 </b> :" +
                name  + "\n" +
                "  <li><b> 网址 </b>: " +
                // 获取 Get 请求中 URL 中的参数 name
                req.getParameter("url") +"\n" +
                "</ul>\n" +
                "</body></html>");

    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
