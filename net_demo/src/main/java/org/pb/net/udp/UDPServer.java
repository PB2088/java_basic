package org.pb.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author boge.peng
 * @create 2018-12-08 11:25
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            //1.使用DatagramSocket指定端口创建接收端
            DatagramSocket server = new DatagramSocket(8888);

            //2.准备容器封装成DatagramPacket
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);

            //3.阻塞式接收包裹
            server.receive(packet);

            byte[] datas = packet.getData();
            System.out.println(new String(datas, 0, packet.getLength()));

            //4.释放资源
            server.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
