package org.pb.net.udp.online;

/**
 * @author boge.peng
 * @create 2018-12-09 16:41
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666,"localhost",9999)).start();
        new Thread(new TalkReceive(8888)).start();

    }
}
