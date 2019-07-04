package org.pb.net.location;

import java.net.InetSocketAddress;

/**
 * @author boge.peng
 * @create 2018-12-08 0:44
 */
public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());

        System.out.println(socketAddress.getAddress().getHostAddress());
    }
}
