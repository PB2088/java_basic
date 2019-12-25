package org.pb.bridge.tradition;

/**
 * 统一消息接口
 * @author bo.peng
 * @create 2019-12-25 16:44
 */
public interface Message {
    /**
     * 发送消息
     * @param message 要发送的消息内容
     * @param receiver 消息接收人
     */
    void send(String message,String receiver);
}
