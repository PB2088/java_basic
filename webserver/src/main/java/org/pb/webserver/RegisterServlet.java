package org.pb.webserver;

/**
 * @author boge.peng
 * @create 2018-12-19 17:52
 */
public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("注册成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("<h1>注册成功,啊哈哈,欢迎你^_^</h1>");
        response.print("</body>");
        response.print("</html>");
    }
}
