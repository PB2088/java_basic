package org.pb.basic.sort;

import java.util.Arrays;

/**
 * @author boge.peng
 * @create 2019-07-08 22:01
 */
public class QuickSort2 implements Sort {
    public static void main(String[] args) {
        long[] array = {3, 9, 1, 4, 7, 8, 5};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        System.out.println("----------------");

        new QuickSort2().sort(array);

        System.out.println("----------------");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序
     *
     * @param array 待排序的数组
     */
    @Override
    public void sort(long[] array) {
        recQuickSort(array, 0, array.length - 1);
    }

    public void recQuickSort(long[] array, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        long pivot = medianOf3(array,left,right);

        int partition = partitionIt(array, left, right, pivot);
        recQuickSort(array, left, partition - 1);
        recQuickSort(array, partition + 1, right);
    }

    private long medianOf3(long[] theArray,int left, int right) {
        int center = (left+right)/2;

        if (theArray[left]>theArray[center]) {
            swap(theArray,left, center);
        }

        if (theArray[left]>theArray[right]) {
            swap(theArray,left, right);
        }

        if (theArray[center]>theArray[right]) {
            swap(theArray,center, right);
        }

        swap(theArray,center, right-1);
        return theArray[right-1];
    }

    private int partitionIt(long[] array, int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right;

        for (;;) {
            while (array[leftPtr] < pivot) {
                leftPtr++;
            }

            while (array[rightPtr] > pivot) {
                rightPtr--;
            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(array, leftPtr, rightPtr);
            }

        }

        return leftPtr;
    }

    private void swap(long[] theArray, int leftPtr, int rightPtr) {
        long temp;
        temp = theArray[leftPtr];
        theArray[leftPtr] = theArray[rightPtr];
        theArray[rightPtr] = temp;
    }
}
