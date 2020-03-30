package org.pb.command.mode;

/**
 * 重启机器命令的实现,实现Command接口
 * @author bo.peng
 * @create 2020-03-30 14:00
 */
public class RestartCommand implements Command {
    private MainBoardApi mainBoard;

    public RestartCommand(MainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        /* 对于命令对象,根据不知道如何重启机器,会转调主板对象,让主板完成重启的功能 */
        mainBoard.restart();
    }
}
