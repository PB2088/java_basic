package org.pb.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @author boge.peng
 * @create 2018-12-18 8:52
 */
public class Request {
    private String requestInfo;
    private String method;
    private String urlStr;
    private String url;
    private StringBuilder requestParam;
    private Map<String, List<String>> paramMap;

    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";

    public Request() {
        requestParam = new StringBuilder(1000);
        paramMap = new HashMap<>();
    }

    public Request(InputStream inputStream) {
        this();
        init(inputStream);
    }

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    private void init(InputStream inputStream) {
        try {
            byte[] datas = new byte[1024 * 1024 * 10];
            int len = inputStream.read(datas);

            requestInfo = new String(datas, 0, len);

            //System.out.println(requestInfo);

            parseMethod();

            parseUrl();

            parseRequestParam();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseMethod() {
        method = requestInfo.substring(0, requestInfo.indexOf("/")).trim();
        //System.out.println("method-------------" + method);
    }

    private void parseUrl() {
        parseUrlStr();

        url = urlStr.isEmpty() ? null : urlStr.contains("?") ? urlStr.split("\\?")[0] : urlStr;
        //System.out.println("url-------------" + url);
    }

    private void convertParamToMap() {

        if (!requestParam.toString().isEmpty()) {
            String[] paramArr = requestParam.toString().split("&");
            for (String param : paramArr) {
                String[] kv = param.split("=");
                kv = Arrays.copyOf(kv, 2);

                if (!paramMap.containsKey(kv[0])) {
                    paramMap.put(kv[0], new ArrayList<>());
                }
                paramMap.get(kv[0]).add(kv[1]);
            }
        }
        //System.out.println("paramMap=================" + paramMap);
    }

    private void parseUrlStr() {
        int beginIndex = requestInfo.indexOf("/") + 1;
        int endIndex = requestInfo.indexOf("HTTP/1.1");

        urlStr = decode(requestInfo.substring(beginIndex, endIndex).trim());
        //System.out.println("urlStr-------------" + urlStr);
    }

    private void parseRequestParam() {
        if (urlStr.contains("?")) {
            requestParam.append(urlStr.split("\\?")[1]);
        }

        if (Objects.equals(method, METHOD_POST)) {
            int beginIndex = requestInfo.lastIndexOf(CommonConstant.NEW_LINE);

            String param = requestInfo.substring(beginIndex).trim();
            if (!param.isEmpty()) {
                requestParam.append("&").append(param);
            }
        }


        convertParamToMap();

        //System.out.println("requestParam-------------" + requestParam);
    }

    private String decode(String value) {
        try {
            return java.net.URLDecoder.decode(value,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getParameter(String key) {
        String[] values = getParameterValues(key);
        return values == null ? null : values[0];
    }

    public String[] getParameterValues(String key) {
        List<String> params = paramMap.get(key);

        return params == null || params.isEmpty() ? null : params.toArray(new String[0]);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
