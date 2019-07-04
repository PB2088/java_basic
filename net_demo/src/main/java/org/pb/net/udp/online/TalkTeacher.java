package org.pb.net.udp.online;

/**
 * @author boge.peng
 * @create 2018-12-09 16:42
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999)).start();
        new Thread(new TalkSend(7777,"localhost",8888)).start();
    }
}
