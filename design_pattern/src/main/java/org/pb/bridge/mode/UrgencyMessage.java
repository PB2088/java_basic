package org.pb.bridge.mode;

/**
 * 加急消息对象
 * @author bo.peng
 * @create 2019-12-30 11:04
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String receiver) {
        super.sendMessage(String.format("加急：%s",message), receiver);
    }

    @Override
    public Object watch(String messageId) {
        /* 获取相应的数据,组织成监控的数据对象,然后返回 */
        System.out.println("加急消息处理过程....");
        return null;
    }
}
