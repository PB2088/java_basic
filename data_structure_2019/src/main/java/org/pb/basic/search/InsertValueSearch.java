package org.pb.basic.search;

import org.pb.util.ToolsUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 插值查找
 * @author boge.peng
 * @create 2019-07-28 20:33
 */
public class InsertValueSearch implements Search {
    public static void main(String[] args) {
        long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 9, 22, 25, 38, 42, 65, 72, 81, 99};

        Search search = new InsertValueSearch();
        System.out.println(search.search(array, 8));
    }

    @Override
    public List<Integer> search(long[] array, long findVal) {
        return recInsertValueSearch(array,0,array.length -1,findVal);
    }

    private List<Integer> recInsertValueSearch(long[] array, int left, int right, long findVal) {

        if (ToolsUtils.isEmpty(array) || left > right || findVal < array[0] || findVal > array[array.length - 1]) {

            return Collections.emptyList();
        }

        int mid = (int) (left + (right - left) * (findVal - array[left])/(array[right]-array[left]));

        if (findVal < array[mid]) {
            return recInsertValueSearch(array, left, mid - 1, findVal);
        } else if (findVal > array[mid]) {
            return recInsertValueSearch(array, mid + 1, right, findVal);
        } else {

            List<Integer> indexs = new ArrayList<>();
            indexs.add(mid);

            /** 向mid左边扫描 */
            int tempIndex = mid - 1;
            for (; ; ) {
                if (tempIndex < 0 || array[tempIndex] != findVal) {
                    break;
                }

                indexs.add(tempIndex);
                tempIndex--;
            }


            /** 向mid右边扫描 */
            tempIndex = mid + 1;
            for (; ; ) {
                if (tempIndex > array.length - 1 || array[tempIndex] != findVal) {
                    break;
                }
                indexs.add(tempIndex);
                tempIndex++;
            }

            return indexs;
        }
    }
}
