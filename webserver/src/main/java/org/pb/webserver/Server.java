package org.pb.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author boge.peng
 * @create 2018-12-15 22:34
 */
public class Server {
    private ServerSocket server;
    private boolean isRunning = true;

    public static void main(String[] args) {
        new Server().start();
    }

    /**
     * 启动服务
     */
    public void start() {
        try {
            server = new ServerSocket(8888);
            receive();

        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
        }
    }

    /**
     * 接受连接服务
     */
    public void receive() {
        try {
            while (isRunning) {
                Socket client = server.accept();
                System.out.println("一个客户端建立了连接");

                new Thread(new Dispatcher(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
        }
    }

    /**
     * 停止服务
     */
    public void stop() {
        try {
            if (server != null) {
                server.close();
            }
            isRunning = false;
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
