package org.pb.webserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-16 23:13
 */
public class Response {
    private BufferedWriter writer;
    private StringBuilder content;
    private StringBuilder headInfo;
    private int length;
    private int statusCode = 200;

    public Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
    }

    public Response(OutputStream outputStream) {
        this();
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public Response(Socket client) throws IOException {
        this(client.getOutputStream());
    }

    public void writer() {
        try {
            if (Objects.equals(content, null)) {
                statusCode = 500;
            }
            buildHeadInfo(statusCode);
            writer.append(headInfo);
            writer.append(content);

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response print(String info) {
        content.append(info);
        length += info.getBytes().length;

        return this;
    }

    public Response println(String info) {
        print(info + CommonConstant.NEW_LINE);

        return this;
    }

    public void buildHeadInfo(int statusCode) {

        headInfo.append("HTTP/1.1").append(CommonConstant.BLANK).append(statusCode)
                .append(CommonConstant.BLANK).append(HTTPStatusCode.getTextBy(statusCode))
                .append(CommonConstant.NEW_LINE);
        headInfo.append("Server:").append(CommonConstant.BLANK).append("pb Server/0.0.1;charset=UTF-8")
                .append(CommonConstant.NEW_LINE);
        headInfo.append("Date:").append(CommonConstant.BLANK).append(new Date()).append(CommonConstant.NEW_LINE);
        headInfo.append("Connection:").append(CommonConstant.BLANK).append("Keep-Alive").append(CommonConstant.NEW_LINE);
        headInfo.append("Content-Type:").append(CommonConstant.BLANK).append("text/html").append(CommonConstant.NEW_LINE);
        headInfo.append("Expries:").append(CommonConstant.BLANK).append(new Date()).append(CommonConstant.NEW_LINE);
        headInfo.append("Cache-control:").append(CommonConstant.BLANK).append("private").append(CommonConstant.NEW_LINE);
        headInfo.append("Content-Length:").append(CommonConstant.BLANK).append(length).append(CommonConstant.NEW_LINE);
        headInfo.append(CommonConstant.NEW_LINE);
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
