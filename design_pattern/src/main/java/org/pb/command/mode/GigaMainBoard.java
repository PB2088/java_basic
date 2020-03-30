package org.pb.command.mode;

/**
 * 技嘉主板类,开机命令的真正实现者,在Command模式中充当Receiver
 * @author bo.peng
 * @create 2020-03-26 14:53
 */
public class GigaMainBoard implements MainBoardApi {
    @Override
    public void open() {
        System.out.println("技嘉主板现在正在开机,请稍等");
        System.out.println("接通电源........");
        System.out.println("设备检查........");
        System.out.println("装载系统........");
        System.out.println("机器正常运行起来........");
        System.out.println("电脑已经正常打开,请操作");
    }

    @Override
    public void restart() {
        System.out.println("技嘉主板现在正在重新启动机器,请稍等");
        System.out.println("机器已正常打开,请操作");
    }
}
