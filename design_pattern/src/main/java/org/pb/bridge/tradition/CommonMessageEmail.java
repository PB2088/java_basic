package org.pb.bridge.tradition;

/**
 * 以E-mail的方法发送普通消息
 * @author bo.peng
 * @create 2019-12-25 16:46
 */
public class CommonMessageEmail implements Message {
    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用E-mail的方式,发送消息：'%s' 给 %s",message,receiver);
    }
}
