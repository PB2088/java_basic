package org.pb.basic.sort;

import java.util.Arrays;

/**
 * @author boge.peng
 * @create 2019-07-07 0:17
 */
public class InsertSort implements Sort {

    public static void main(String[] args) {
        long[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 9};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new InsertSort().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     *
     * @param array 待排序的数组
     */
    @Override
    public void sort(long[] array) {

        for (int i = 1; i < array.length; i++) {
            long insertVal = array[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertVal;
            }

            /*System.out.printf("第%d轮插入排序\n",i);
            System.out.println(Arrays.toString(array));*/
        }

    }
}
