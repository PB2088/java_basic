package org.pb.adapter.mode;

import org.pb.util.CommonUtils;
import org.pb.util.ToolsUtils;

import java.io.*;
import java.util.List;

/**
 * 实现对日志文件的操作
 *
 * @author bo.peng
 * @create 2019-12-24 17:09
 */
public class LogFileOperateApiImpl implements LogFileOperateApi {
    /**
     * 日志文件的路径和文件名称,默认为当前项目下的AdapterLog.log
     */
    private static final String LOG_FILE_PATH_NAME = "design_pattern/AdapterLog.log";

    private String logFilePathName;

    public LogFileOperateApiImpl(String logFilePathName) {
        this.logFilePathName = ToolsUtils.notEmpty(logFilePathName) ? logFilePathName : LOG_FILE_PATH_NAME;
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> logModels = null;
        ObjectInputStream ois = null;
        File file = new File(logFilePathName);
        try {
            if (file.exists()) {
                ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

                logModels = (List<LogModel>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            CommonUtils.close(ois);
        }

        return logModels;
    }

    @Override
    public void writeLogFile(List<LogModel> logModelList) {

        File file = new File(logFilePathName);
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            oos.writeObject(logModelList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
