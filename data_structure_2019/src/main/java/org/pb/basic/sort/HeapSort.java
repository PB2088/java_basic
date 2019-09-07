package org.pb.basic.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author bo.peng
 * @create 2019-09-04 9:54
 */
public class HeapSort implements Sort {
    public static void main(String[] args) {
        long[] array = {10, 25, 15, 20, 35, 40, 30, 50, 45, 60, 65};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new HeapSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }


    @Override
    public void sort(long[] array) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            long temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            adjustHeap(array,0,i);
        }

    }

    /**
     * @param array  待调整的数组
     * @param index  非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整
     */
    public void adjustHeap(long[] array, int index, int length) {
        long temp = array[index];

        for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
            /** 左子节点的值小于右子节点的值,k指向右子节点 */
            if ((k + 1) < length && array[k] < array[k + 1]) {
                k++;
            }

            /** 如果子节点大于父节点,把较大的值赋值给父节点 */
            if (array[k] > temp) {
                array[index] = array[k];
                index = k;
            } else {
                break;
            }
        }

        array[index] = temp;
    }
}
