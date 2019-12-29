package org.pb.bridge.tradition;

/**
 * 以站内短消息的方法发送特急消息
 * @author bo.peng
 * @create 2019-12-25 16:57
 */
public class SpecialUrgencyMessageSMS implements SpecialUrgencyMessage {
    @Override
    public Object watch(String messageId) {
        //TODO:获取相应的数据,组织成监控的数据对象,然后返回
        return null;
    }

    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用站内短消息的方式,发送消息：'特急：%s' 给 %s",message,receiver);
    }
}
