package org.pb.command.mode;

/**
 * @author bo.peng
 * @create 2020-03-26 15:10
 */
public class Client {
    public static void main(String[] args) {
        /* 1.把命令和真正的实现组合起来,相当于在组装机器 */
        MainBoardApi mainBoard = new MsiMainBoard();
        OpenCommand openCommand = new OpenCommand(mainBoard);

        /* 2.为机箱上的按钮设置对应的命令,让按钮知道该干什么 */
        Box box = new Box();
        box.setOpenCommand(openCommand);

        /* 3.然后模拟按下机箱上的按钮 */
        box.openButtonPressed();
    }
}
