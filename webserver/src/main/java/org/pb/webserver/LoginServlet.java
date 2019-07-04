package org.pb.webserver;

/**
 * @author boge.peng
 * @create 2018-12-19 17:52
 */
public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("服务器响应成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("<h1>登陆成功,终于回来了......^_^</h1>");
        response.print("</body>");
        response.print("</html>");
    }
}
