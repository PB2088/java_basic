package org.pb.basic.sort;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;

/**
 * 归并排序
 *
 * @author boge.peng
 * @create 2019-07-20 19:31
 */
public class MergeSort implements Sort {

    public static void main(String[] args) {
        long[] array = {3, 9, 1, 4, 7, 8, 5,0,2,-1,11,-2,22,13,6};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new MergeSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(long[] array) {
        long[] workSpace = new long[array.length];
        recMergeSort(array, 0, array.length - 1, workSpace);
    }

    /**
     * 归并排序具体操作
     * @param theArray 待排序的数组
     * @param lowerBound
     * @param highBound
     * @param workSpace
     */
    private void recMergeSort(long[] theArray, int lowerBound, int highBound, long[] workSpace) {
        if (lowerBound == highBound) {
            return;
        }

        int mid = (lowerBound + highBound) / 2;

        /** 归并排序左边数据 */
        recMergeSort(theArray, lowerBound, mid, workSpace);
        /** 归并排序右边数据 */
        recMergeSort(theArray, mid + 1, highBound, workSpace);

        /** 合并 */
        merge(theArray, lowerBound, mid + 1, highBound, workSpace);
    }

    /**
     * @param theArray
     * @param lowerIndex
     * @param highIndex
     * @param highBound
     * @param workSpace
     */
    private void merge(long[] theArray, int lowerIndex, int highIndex, int highBound, long[] workSpace) {

        /** 记录左边的最小索引边界(复制用) */
        int lowerCopyIndex = lowerIndex;

        /** 记录左边的最大索引边界 */
        int lowerBound = highIndex - 1;

        /** 最后合并到workSpace的索引记录 */
        int workSpaceIndex = 0;
        /** 1:从左边依次取值跟右边的数据依次比较 */
        while (lowerIndex <= lowerBound && highIndex <= highBound) {
            if (theArray[lowerIndex] < theArray[highIndex]) {
                workSpace[workSpaceIndex++] = theArray[lowerIndex++];
            } else {
                workSpace[workSpaceIndex++] = theArray[highIndex++];
            }
        }

        /** 2.分别处理两边还剩下的数据 */
        /** 2.1处理左边还剩下的数据 */
        while (lowerIndex <= lowerBound) {
            workSpace[workSpaceIndex++] = theArray[lowerIndex++];
        }

        /** 2.2处理右边还剩下的数据 */
        while (highIndex <= highBound) {
            workSpace[workSpaceIndex++] = theArray[highIndex++];
        }


        /** 3.把排好顺序的数据,重新拷贝回theArray */
        /*System.arraycopy(workSpace, 0, theArray, lowerCopyIndex, (highBound - lowerCopyIndex + 1));*/
        for (int i=0;i<(highBound-lowerCopyIndex+1);i++) {
            theArray[lowerCopyIndex+i] = workSpace[i];
        }
    }
}
