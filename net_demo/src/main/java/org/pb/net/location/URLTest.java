package org.pb.net.location;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author boge.peng
 * @create 2018-12-08 10:35
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com:1080/docs/resource1.html");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getFile());
            System.out.println(url.getPath());
            System.out.println(url.getPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
