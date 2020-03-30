package org.pb.command.mode;

/**
 * 机箱对象,本身有按钮,持有按钮对应的命令对象
 * @author bo.peng
 * @create 2020-03-26 15:06
 */
public class Box {
    /** 开机命令对象 */
    private Command openCommand;

    /** 重启命令对象 */
    private Command restartCommand;

    /**
     * 设置开机命令对象
     * @param openCommand
     */
    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    /**
     * 设置重启命令对象
     * @param restartCommand
     */
    public void setRestartCommand(Command restartCommand) {
        this.restartCommand = restartCommand;
    }

    /**
     * 提供给客户使用,接收并响应客户请求,相当于开机按钮被按下触发的方法
     */
    public void openButtonPressed() {
        /* 按下按钮,执行命令 */
        openCommand.execute();
    }

    /**
     * 提供给客户使用,接收并响应客户请求,相当于重启按钮被按下触发的方法
     */
    public void restartButtonPressed() {
        /* 按下按钮,执行命令 */
        restartCommand.execute();
    }
}
