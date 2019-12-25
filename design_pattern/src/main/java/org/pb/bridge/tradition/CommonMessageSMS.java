package org.pb.bridge.tradition;

/**
 * 以站内短消息的方法发送普通消息
 * @author bo.peng
 * @create 2019-12-25 16:46
 */
public class CommonMessageSMS implements Message {
    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用站内短消息的方式,发送消息：'%s' 给 %s",message,receiver);
    }
}
