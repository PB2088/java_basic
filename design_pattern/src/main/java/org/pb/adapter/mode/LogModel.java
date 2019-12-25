package org.pb.adapter.mode;

import java.io.Serializable;

/**
 * 日志数据对象
 * @author bo.peng
 * @create 2019-12-24 17:03
 */
public class LogModel implements Serializable {
    /** 日志编号 */
    private String logId;

    /** 操作人员 */
    private String operateUser;

    /** 操作时间,格式：yyy-MM-dd HH:mm:ss */
    private String operateTime;

    /** 日志内容 */
    private String logContent;

    @Override
    public String toString() {
        return String.format("logId=%s,operateUser=%s,operateTime=%s,logContent=%s",logId,operateUser,operateTime,logContent);
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
}
