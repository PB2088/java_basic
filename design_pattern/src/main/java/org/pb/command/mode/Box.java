package org.pb.command.mode;

/**
 * 机箱对象,本身有按钮,持有按钮对应的命令对象
 * @author bo.peng
 * @create 2020-03-26 15:06
 */
public class Box {
    /** 开机命令对象 */
    private Command openCommand;

    /**
     * 设置开机命令对象
     * @param openCommand
     */
    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    /**
     * 提供给客户使用,接收并响应客户请求,相当于按钮被按下触发的方法
     */
    public void openButtonPressed() {
        /* 按下按钮,执行命令 */
        openCommand.execute();
    }
}
