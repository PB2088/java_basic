package org.pb.adapter.mode;

import java.util.List;
import java.util.Objects;

/**
 * 适配器对象,将记录到日志文件的功能适配成第二版需要的增删改查功能
 * @author bo.peng
 * @create 2019-12-25 14:03
 */
public class LogOperateAdapter implements LogDbOperateApi {
    private LogFileOperateApi adaptee;

    public LogOperateAdapter(LogFileOperateApi adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int createLog(LogModel logModel) {
        /* 1.先读取日志文件的内容 */
        List<LogModel> logModels = adaptee.readLogFile();

        /* 2.加入新的日志对象 */
        logModels.add(logModel);

        /* 3.重新写入日志文件 */
        adaptee.writeLogFile(logModels);

        return 0;
    }

    @Override
    public int updateLog(LogModel logModel) {
        /* 先读取文件的内容 */
        List<LogModel> logModels = adaptee.readLogFile();
        /* 修改相应的日志对象 */
        for (int i = 0; i < logModels.size(); i++) {
            if (Objects.equals(logModels.get(i).getLogId(),logModel.getLogId())) {
                logModels.set(i,logModel);
                break;
            }
        }

        /* 重新写入日志文件 */
        adaptee.writeLogFile(logModels);

        return 0;
    }

    @Override
    public int removeLog(LogModel logModel) {
        /* 1.先读取文件的内容 */
        List<LogModel> logModels = adaptee.readLogFile();

        /* 删除相应的日志 */
        logModels.remove(logModel);

        /* 重新写入日志文件 */
        adaptee.writeLogFile(logModels);

        return 0;
    }

    @Override
    public List<LogModel> getAll() {
        return adaptee.readLogFile();
    }
}
