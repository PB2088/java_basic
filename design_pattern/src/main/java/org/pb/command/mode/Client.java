package org.pb.command.mode;

/**
 * @author bo.peng
 * @create 2020-03-26 15:10
 */
public class Client {
    public static void main(String[] args) {
        /* 1.把命令和真正的实现组合起来,相当于在组装机器 */
        MainBoardApi mainBoard = new MsiMainBoard();
        /* 创建开机命令 */
        OpenCommand openCommand = new OpenCommand(mainBoard);
        /* 创建重启机器的命令 */
        RestartCommand restartCommand = new RestartCommand(mainBoard);

        /* 2.为机箱上的按钮设置对应的命令,让按钮知道该干什么 */
        Box box = new Box();
        box.setOpenCommand(openCommand);
        box.setRestartCommand(restartCommand);

        /* 3.然后模拟按下机箱上的按钮 */
        System.out.println("正确配置下--------------------------------->");
        System.out.println(">>>按下开机按钮:>>>");
        box.openButtonPressed();

        System.out.println(">>>按下重启按钮:>>>");
        box.restartButtonPressed();

        System.out.println("错误配置下--------------------------------->");
        box.setOpenCommand(restartCommand);
        box.setRestartCommand(openCommand);

        System.out.println(">>>按下开机按钮:>>>");
        box.openButtonPressed();

        System.out.println(">>>按下重启按钮:>>>");
        box.restartButtonPressed();


    }
}
