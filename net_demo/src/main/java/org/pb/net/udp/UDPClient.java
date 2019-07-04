package org.pb.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author boge.peng
 * @create 2018-12-08 11:25
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            //1.使用DatagramSocket指定端口创建发送端
            DatagramSocket client = new DatagramSocket(6666);
 
            //2.准备数据
            byte[] datas = "中华人民共和国".getBytes();

            //3.封装成DatagramPacket包裹,需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));

            //4.发送包裹
            client.send(packet);

            //5.释放资源
            client.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
