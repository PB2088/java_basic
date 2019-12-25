package org.pb.adapter.mode;

import java.util.List;

/**
 * 日志操作接口
 * @author bo.peng
 * @create 2019-12-25 11:24
 */
public interface LogDbOperateApi {
    /**
     * 新增日志对象
     * @param logModel 需要新增的日志对象
     * @return
     */
    int createLog(LogModel logModel);

    /**
     * 修改日志对象
     * @param logModel 需要新增的日志对象
     * @return
     */
    int updateLog(LogModel logModel);

    /**
     * 删除日志对象
     * @param logModel 需要删除的日志对象
     * @return
     */
    int removeLog(LogModel logModel);

    /**
     * 获取所有的日志
     * @return 所有的日志对象
     */
    List<LogModel> getAll();

}
