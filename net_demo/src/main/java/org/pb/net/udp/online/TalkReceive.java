package org.pb.net.udp.online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-09 16:39
 */
public class TalkReceive implements Runnable {

    private int port;

    public TalkReceive(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            //1.使用DatagramSocket指定端口创建接收端
            DatagramSocket server = new DatagramSocket(port);

            //2.准备容器封装成DatagramPacket
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            while (true) {

                //3.阻塞式接收包裹
                server.receive(packet);

                byte[] datas = packet.getData();

                String msg = new String(datas, 0, packet.getLength());

                System.out.println(msg);

                if (Objects.equals("bye", msg)) {
                    break;
                }
            }

            //4.释放资源
            server.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
