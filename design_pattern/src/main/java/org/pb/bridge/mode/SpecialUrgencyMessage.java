package org.pb.bridge.mode;

/**
 * 特急消息对象
 * @author bo.peng
 * @create 2019-12-30 15:32
 */
public class SpecialUrgencyMessage extends AbstractMessage {
    public SpecialUrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String receiver) {
        super.sendMessage(String.format("特急：%s",message), receiver);
        hurry(null);
        watch(null);
    }

    public void hurry(String messageId) {
        /* 执行催促业务处理 */
        System.out.println("特急消息催促处理....");
    }

    @Override
    public Object watch(String messageId) {
        /* 获取相应的数据,组织成监控的数据对象,然后返回 */
        System.out.println("特急消息监控处理过程....");
        return null;
    }
}
