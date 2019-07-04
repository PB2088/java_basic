package org.pb.net.udp.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-08 11:25
 */
public class UDPClient {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            //1.使用DatagramSocket指定端口创建发送端
            DatagramSocket client = new DatagramSocket(6666);
            InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8888);

            //2.准备数据
            while (true) {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                //3.封装成DatagramPacket包裹,需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, socketAddress);
                //4.发送包裹
                client.send(packet);

                if (Objects.equals("bye",data)) {
                    break;
                }
            }

            //5.释放资源
            client.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
