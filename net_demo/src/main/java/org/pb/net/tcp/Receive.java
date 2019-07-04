package org.pb.net.tcp;

import org.pb.net.tcp.util.CommonUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author boge.peng
 * @create 2018-12-11 12:16
 */
public class Receive implements Runnable {
    private Socket client;
    private DataInputStream dis;

    private boolean isRunning=true;

    public Receive(Socket client) {
        this.client = client;
        init();
    }

    private void init() {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String message = receive();
            System.out.println(message);
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
            e.printStackTrace();
            release();
        }
        return null;
    }

    /**
     * 释放资源
     */
    private void release() {
        isRunning = false;
        CommonUtils.close(dis,client);
    }
}
