package org.pb.basic.search;

import org.pb.util.ToolsUtils;

/**
 * 顺序查找
 * @author boge.peng
 * @create 2019-07-24 23:02
 */
public class SequentialSearch implements Search {
    public static void main(String[] args) {

        long[] array = {3, 9, 1, 4, 7, 8, 5};

        Search search = new SequentialSearch();
        System.out.println(search.search(array, 3));

    }

    /**
     * 顺序查询方法
     * @param array 被查找的数组
     * @param findVal 被查找的关键值
     * @return 被查找的关键值在数组中的索引位置,未找到返回-1
     */
    @Override
    public int search(long[] array, long findVal) {
        if (ToolsUtils.isEmpty(array)) {
            throw new RuntimeException("数组为空!");
        }

        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findVal) {
                index = i;
                break;
            }
        }

        return index;
    }
}
