package org.pb.webserver;

/**
 * @author boge.peng
 * @create 2018-12-19 17:52
 */
public class OtherServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("其他Servlet请求处理!!");
    }
}
