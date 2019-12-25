package org.pb.adapter.mode;

import org.pb.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bo.peng
 * @create 2019-12-25 10:53
 */
public class Client {
    public static void main(String[] args) {
        LogModel logModel = new LogModel();
        logModel.setLogId("001");
        logModel.setOperateUser("admin");
        logModel.setOperateTime(DateUtil.parseDateToStr(DateUtil.now(), DateUtil.FormatPattern.DATE_TIME_FORMAT_PATTERN));
        logModel.setLogContent("这是一个适配器模式测试");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);

        LogFileOperateApi api = new LogFileOperateApiImpl(null);

        LogDbOperateApi adapter = new LogOperateAdapter(api);
        adapter.updateLog(logModel);

        System.out.println(adapter.getAll());

        adapter.removeLog(logModel);

        System.out.println(adapter.getAll());

    }
}
