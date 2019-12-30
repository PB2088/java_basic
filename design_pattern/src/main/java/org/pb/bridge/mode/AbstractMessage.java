package org.pb.bridge.mode;

import java.util.Objects;

/**
 * 抽象的消息对象
 * @author bo.peng
 * @create 2019-12-30 10:55
 */
public abstract class AbstractMessage {
    /** 持有一个实现部分的对象 */
    protected MessageImplementor implementor;

    public AbstractMessage(MessageImplementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 发送消息
     * @param message 要发送的消息内容
     * @param receiver 发的消息的接收者
     */
    public void sendMessage(String message, String receiver) {
        implementor.send(message,receiver);
    }

    /**
     * 监控某消息的处理过程
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象,这里示意一下,所以用Object
     */
    public abstract Object watch(String messageId);
}
