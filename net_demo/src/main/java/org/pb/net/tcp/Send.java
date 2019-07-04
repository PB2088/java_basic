package org.pb.net.tcp;

import org.pb.net.tcp.util.CommonUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-11 12:06
 */
public class Send implements Runnable {
    private Socket client;
    private DataOutputStream dos;
    private BufferedReader console;

    private boolean isRunning=true;

    public Send(Socket client) {
        this.client = client;
        init();
    }

    private void init() {
        try {
            dos = new DataOutputStream(client.getOutputStream());
            console = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            release();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String message = getMessageFromConsole();
            if (!Objects.equals(message,null) && !message.isEmpty()) {
                send(message);
            }
        }
    }

    private String getMessageFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
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
            release();
        }
    }

    /**
     * 释放资源
     */
    private void release() {
        isRunning = false;
        CommonUtils.close(console,dos,client);
    }
}
