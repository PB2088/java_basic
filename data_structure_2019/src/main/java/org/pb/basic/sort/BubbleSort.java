package org.pb.basic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author bo.peng
 * @create 2019-07-04 13:56
 */
public class BubbleSort implements Sort{
    public static void main(String[] args) {
        long[] array = {5, 3, 2, 1,4, 7, 8, 9};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new BubbleSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * @param array 待排序的数组
     */
    @Override
    public void sort(long[] array) {
        boolean isStop = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    long temp;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    isStop = true;
                }
            }

            if (!isStop) {
                break;
            } else {
                isStop = false;
            }

/*            System.out.printf("第%d趟排序\n",i+1);
            System.out.println(Arrays.toString(array));*/
        }
    }
}
