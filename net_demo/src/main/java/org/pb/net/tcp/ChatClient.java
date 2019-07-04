package org.pb.net.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @author boge.peng
 * @create 2018-12-09 18:53
 */
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            new Thread(new Send(socket)).start();
            new Thread(new Receive(socket)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
