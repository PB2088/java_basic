package org.pb.bridge.mode;

/**
 * 以站内短消息的方法发消息
 * @author bo.peng
 * @create 2019-12-30 10:59
 */
public class MessageSMSImplementor implements MessageImplementor {
    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用站内短消息的方式,发送消息：'%s' 给 %s\n",message,receiver);
    }
}
