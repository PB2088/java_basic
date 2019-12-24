package org.pb.adapter.mode;

import org.pb.util.ToolsUtils;

import java.util.List;

/**
 * @author bo.peng
 * @create 2019-12-24 17:09
 */
public class LogFileOperateApiImpl implements LogFileOperateApi {
    /** 日志文件的路径和文件名称,默认为当前项目下的AdapterLog.log */
    private static final String LOG_FILE_PATH_NAME = "AdapterLog.log";

    private String logFilePathName;

    public LogFileOperateApiImpl(String logFilePathName) {
        this.logFilePathName = ToolsUtils.notEmpty(logFilePathName) ? logFilePathName : LOG_FILE_PATH_NAME;
    }

    @Override
    public List<LogModel> readLogFile() {
        return null;
    }

    @Override
    public void writeLogFile(List<LogModel> logModelList) {

    }
}
