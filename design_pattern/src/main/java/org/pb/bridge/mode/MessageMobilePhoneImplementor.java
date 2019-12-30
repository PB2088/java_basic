package org.pb.bridge.mode;

/**
 * 使用手机的方法发消息
 * @author bo.peng
 * @create 2019-12-30 10:59
 */
public class MessageMobilePhoneImplementor implements MessageImplementor {
    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用手机的方式,发送消息：'%s' 给 %s\n",message,receiver);
    }
}
