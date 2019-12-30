package org.pb.bridge.mode;

/**
 * @author bo.peng
 * @create 2019-12-30 14:17
 */
public class Client {
    public static void main(String[] args) {
        /* 创建具体的实现对象 */
        MessageImplementor implementor = new MessageSMSImplementor();

        /* 创建一个普通的消息 */
        AbstractMessage message = new CommonMessage(implementor);

        message.sendMessage("下去走走麽？","皮皮虾");

        AbstractMessage urgencyMessage = new UrgencyMessage(implementor);
        urgencyMessage.sendMessage("下去走走麽？","皮皮虾");

        MessageImplementor mobilePhoneImplementor = new MessageMobilePhoneImplementor();
        message.implementor = mobilePhoneImplementor;
        message.sendMessage("下去走走麽？","皮皮虾");

        SpecialUrgencyMessage specialUrgencyMessage = new SpecialUrgencyMessage(mobilePhoneImplementor);
        specialUrgencyMessage.sendMessage("下去走走麽？","皮皮虾");
    }
}
