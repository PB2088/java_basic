package org.pb.webserver;

import org.pb.webserver.utils.CommonUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-19 23:13
 */
public class Dispatcher implements Runnable {
    private Request request;
    private Response response;
    private Socket client;

    public Dispatcher(Socket client) {
        this.client = client;
        init();
    }

    private void init() {
        try {
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        WebApp webApp = new WebApp();
        WebContext context = webApp.getContext();
        Servlet servlet = context.getServletByUrl(request.getUrl());
        if (!Objects.equals(null, servlet)) {
            servlet.service(request, response);
        } else {

        }

        response.writer();

        release();
    }

    /**
     * 释放资源
     */
    private void release() {
        CommonUtils.close(client);
    }
}
