package org.pb.bridge.mode;

/**
 * 实现发送消息的统一接口
 * @author bo.peng
 * @create 2019-12-30 10:53
 */
public interface MessageImplementor {
    /**
     * 发送消息
     * @param message 要发送的消息内容
     * @param receiver 消息接收者
     */
    void send(String message, String receiver);
}
