package org.pb.net.tcp;

import org.pb.net.tcp.util.CommonUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-09 18:50
 */
public class ChatServer {
    private static List<Channel> chatRoot = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(8888);

            while (true) {
                Socket client = serverSock.accept();
                System.out.println("一个客户端建立了连接");

                Channel channel = new Channel(client);
                chatRoot.add(channel);

                new Thread(channel).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Channel implements Runnable{

        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        private boolean isRunning=true;

        public Channel(Socket client) {
            this.client = client;

            init();
        }

        private void init() {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 接收消息
         *
         * @return
         */
        private String receive() {
            try {
                return dis.readUTF();
            } catch (IOException e) {
                System.out.println(Thread.currentThread().getName() + " call receive() Error");
                release();
            }
            return null;
        }

        /**
         * 发送消息
         *
         * @param message
         */
        private void send(String message) {
            try {
                dos.writeUTF(message);
                dos.flush();
            } catch (IOException e) {
                System.out.println(Thread.currentThread().getName() + " call send("+message+") Error");
                release();
            }
        }

        private void sendOthers(String message) {
            for (Channel channel : chatRoot) {
                if (channel == this) {
                    continue;
                } else {
                    channel.send(message);
                }
            }
        }

        /**
         * 释放资源
         */
        private void release() {
            isRunning = false;
            CommonUtils.close(dos, dis, client);
        }

        @Override
        public void run() {
            while (isRunning) {
                String message = receive();
                if (!Objects.equals(message,null) && !message.isEmpty()) {
                    sendOthers(message);
                }
            }
        }
    }
}
