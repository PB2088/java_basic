package org.pb.webserver;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP状态码
 * @author boge.peng
 * @create 2018-12-17 0:13
 */
public enum HTTPStatusCode {
    STATUS_200(200,"OK"),
    STATUS_400(400,"Bad Request"),
    STATUS_403(403,"Forbidden"),
    STATUS_404(404,"Not Found"),
    STATUS_500(500,"Internal Server Error");

    private int code;
    private String text;

    private HTTPStatusCode(int code,String text) {
        this.code = code;
        this.text = text;
    }

    private static final Map<Integer,HTTPStatusCode> enumMap = new HashMap<>();
    static {
        enumMap.put(STATUS_200.code,STATUS_200);
        enumMap.put(STATUS_400.code,STATUS_400);
        enumMap.put(STATUS_403.code,STATUS_403);
        enumMap.put(STATUS_404.code,STATUS_404);
        enumMap.put(STATUS_500.code,STATUS_500);
    }

    public static String getTextBy(int code) {
        return enumMap.containsKey(code)?enumMap.get(code).text:"";
    }
}
