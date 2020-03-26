package org.pb.command.mode;

/**
 * 命令接口,声明执行的操作
 * @author bo.peng
 * @create 2020-03-26 15:01
 */
public interface Command {
    /**
     * 执行命令对应的操作
     */
    void execute();
}
