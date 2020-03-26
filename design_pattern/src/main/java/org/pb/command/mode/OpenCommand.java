package org.pb.command.mode;

/**
 * 开机命令的实现,实现Command接口
 * @author bo.peng
 * @create 2020-03-26 15:02
 */
public class OpenCommand implements Command {
    private MainBoardApi mainBoard;

    public OpenCommand(MainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        /* 对于命令对象,根据不知道如何开机,会转调主板对象,让主板完成开机的功能 */
        mainBoard.open();
    }
}
