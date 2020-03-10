package org.pb.flyweight.tradition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 供测试用,在内存中模拟数据库中的值
 *
 * @author bo.peng
 * @create 2020-03-10 13:46
 */
public class TestDB {
    public static List<String> colDB = new ArrayList<>();

    static {
        colDB.add("张三,人员列表,查看");
        colDB.add("李四,人员列表,查看");
        colDB.add("李四,薪资数据,查看");
        colDB.add("李四,薪资数据,修改");

        /*增加更多的授权数据*/
        for (int i = 0; i < 3; i++) {
            colDB.add("张三" + i + ",人员列表,查看");
        }
    }
}
