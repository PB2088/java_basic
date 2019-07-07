package org.pb.basic.sort;

import java.util.Arrays;

/**
 * @author boge.peng
 * @create 2019-07-06 13:52
 */
public class SelectSort implements Sort {

    public static void main(String[] args) {
        long[] array = {5, 3, 2, 1, 4, 7, 8, 9};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new SelectSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     *
     * @param array 待排序的数组
     */
    @Override
    public void sort(long[] array) {
        for (int out = 0; out < array.length - 1; out++) {
            int minIndex = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[minIndex]) {
                    minIndex = in;
                }
            }
            swap(array, out, minIndex);

/*            System.out.printf("第%d趟排序\n", out + 1);
            System.out.println(Arrays.toString(array));*/
        }
    }

    private void swap(long[] array, int out, int min) {
        long temp = array[out];
        array[out] = array[min];
        array[min] = temp;
    }
}
