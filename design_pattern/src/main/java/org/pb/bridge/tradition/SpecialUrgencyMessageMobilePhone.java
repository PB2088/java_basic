package org.pb.bridge.tradition;

/**
 * 以手机的方法发送特急消息
 * @author bo.peng
 * @create 2019-12-25 16:58
 */
public class SpecialUrgencyMessageMobilePhone implements SpecialUrgencyMessage {
    @Override
    public Object watch(String messageId) {
        //TODO:获取相应的数据,组织成监控的数据对象,然后返回
        return null;
    }

    @Override
    public void send(String message, String receiver) {
        System.out.printf("使用手机的方式,发送消息：'特急：%s' 给 %s",message,receiver);
    }
}
