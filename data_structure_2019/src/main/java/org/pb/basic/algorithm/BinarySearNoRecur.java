package org.pb.basic.algorithm;

import org.pb.basic.search.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * 二分查找(非递归版)
 *
 * @author bo.peng
 * @create 2019-11-10 20:00:00
 */
public class BinarySearNoRecur implements Search {
    public static void main(String[] args) {
        long[] array = {1, 2, 3, 4, 5, 6, 7,8,8, 8,8,8, 9, 22, 25, 38, 42, 65, 72, 81, 99};

        Search search = new BinarySearNoRecur();
        System.out.println(search.search(array, 8));
    }
    @Override
    public List<Integer> search(long[] array, long findVal) {
        int left = 0;
        int right = array.length -1;
        List<Integer> indexs = new ArrayList<>();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > findVal) {
                right = mid - 1;
            } else if (array[mid] < findVal) {
                left = mid + 1;
            } else {
                indexs.add(mid);

                /** 向mid左边扫描 */
                int tempIndex = mid -1;
                for (; ; ) {
                    if (tempIndex < 0 || array[tempIndex] != findVal) {
                        break;
                    }
                    indexs.add(tempIndex);
                    tempIndex--;
                }

                /** 向mid右边扫描 */
                tempIndex = mid + 1;
                for (;;) {
                    if (tempIndex > array.length -1 | array[tempIndex] != findVal) {
                        break;
                    }
                    indexs.add(tempIndex);
                    tempIndex++;
                }
                break;
            }
        }

        return indexs;
    }
}
