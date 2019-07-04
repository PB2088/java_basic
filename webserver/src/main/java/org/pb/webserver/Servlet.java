package org.pb.webserver;

/**
 * @author boge.peng
 * @create 2018-12-19 17:51
 */
public interface Servlet {
    void service(Request request, Response response);
}
