package org.pb.bridge.tradition;

/**
 * 紧急消息的抽象接口
 * @author bo.peng
 * @create 2019-12-25 16:54
 */
public interface UrgencyMessage extends Message {
    /**
     * 监控某消息的处理进度
     * @param messageId 被监控的消息编号
     * @return 包含监控到的数据对象,这里示意一下,所以使用Object
     */
    Object watch(String messageId);
}
