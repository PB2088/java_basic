package org.pb.net.location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author boge.peng
 * @create 2018-12-08 0:27
 */
public class IPTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());

            //根据域名得到InetAddress对象
            inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
