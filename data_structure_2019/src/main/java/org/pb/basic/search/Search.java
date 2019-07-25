package org.pb.basic.search;

/**
 * 查找接口
 * @author boge.peng
 * @create 2019-07-24 23:03
 */
public interface Search {
    /**
     * 查询方法,具体由子类实现
     * @param array 被查找的数组
     * @param findVal 被查找的关键值
     * @return 被查找的关键值在数组中的索引位置,未找到返回-1
     */
    int search(long[] array,long findVal);
}
