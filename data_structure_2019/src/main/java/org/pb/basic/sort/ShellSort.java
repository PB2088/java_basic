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
        long[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
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
/*        int h = 1;
        while (h < array.length / 3) {
            h = h * 3 + 1;
        }*/

        for (int h = array.length / 2; h > 0; h /= 2) {
            for (int i = h; i < array.length; i++) {
                for (int j = i -h;j >= 0;j -=h) {
                    if (array[j] > array[j+h]) {
                        long temp = array[j];
                        array[j] = array[j+h];
                        array[j+h] = temp;
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(array));
    }

    private void sortOf(long[] array) {
/*        int h = 1;
        while (h < array.length / 3) {
            h = h * 3 + 1;
        }*/

        for (int h = array.length / 2; h > 0; h /= 2) {
            for (int i = h; i < array.length; i++) {
                for (int j = i -h;j >= 0;j -=h) {
                    if (array[j] > array[j+h]) {
                        long temp = array[j];
                        array[j] = array[j+h];
                        array[j+h] = temp;
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(array));
    }

}
