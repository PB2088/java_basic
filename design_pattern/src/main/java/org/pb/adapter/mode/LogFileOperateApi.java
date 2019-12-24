package org.pb.adapter.mode;

import java.util.List;

/**
 * 日志文件操作接口
 * @author bo.peng
 * @create 2019-12-24 17:07
 */
public interface LogFileOperateApi {
    /**
     * 读取日志文件,从文件中获取存储的日志列表信息
     * @return
     */
    List<LogModel> readLogFile();

    /**
     * 写日志文件, 把日志列表写入日志文件中
     * @param logModelList
     */
    void writeLogFile(List<LogModel> logModelList);
}
