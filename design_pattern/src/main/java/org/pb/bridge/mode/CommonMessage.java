package org.pb.bridge.mode;

/**
 * 普通消息对象
 * @author bo.peng
 * @create 2019-12-30 11:02
 */
public class CommonMessage extends AbstractMessage {
    public CommonMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String receiver) {
        /* 对于普通消息,什么都不做,直接调用父类的方法,把消息发送出去既可 */
        super.sendMessage(message, receiver);
    }

    @Override
    public Object watch(String messageId) {
        /* 普通消息不需要监控消息的处理过程 */
        return null;
    }
}
