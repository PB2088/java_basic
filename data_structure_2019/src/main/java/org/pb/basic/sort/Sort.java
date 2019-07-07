package org.pb.basic.sort;

/**
 * 排序接口
 * @author boge.peng
 * @create 2019-07-06 13:48
 */
public interface Sort {
    /**
     * 排序方法,具体由子类实现
     * @param array 待排序的数组
     */
    void sort(long[] array);
}
