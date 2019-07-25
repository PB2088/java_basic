package org.pb.basic.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author boge.peng
 * @create 2019-07-07 14:53
 */
public class ShellSort implements Sort {
    public static void main(String[] args) {
        long[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 9, 1, 7, 8};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new ShellSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序
     *
     * @param array 待排序的数组
     */
    @Override
    public void sort(long[] array) {
        int h = 1;
        while (h < array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int out = h; out < array.length; out++) {
                long insertVal = array[out];
                int insertIndex = out;

                while (insertIndex - h >= 0 && insertVal < array[insertIndex - h]) {
                    array[insertIndex] = array[insertIndex - h];
                    insertIndex -= h;
                }

                array[insertIndex] = insertVal;
            }

            h = (h - 1) / 3;
        }

        //System.out.println(Arrays.toString(array));
    }

}
