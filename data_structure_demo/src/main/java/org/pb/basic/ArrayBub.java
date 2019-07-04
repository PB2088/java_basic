package org.pb.basic;

public class ArrayBub {
    private long[] arr;
    private int index;

    /**
     * 构造方法
     * @param maxSize
     */
    public ArrayBub(int maxSize) {
        if (maxSize<=0) {
            maxSize = 1;
        }
        arr = new long[maxSize];
        index = 0;
    }

    /**
     *
     *<p>
     *description:插入元素
     *</p>
     * @param value
     * @return
     * @author ex_pengbo
     * @see
     */
    public boolean insert(long value) {
        if (index < arr.length) {
            arr[index++] = value;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     *<p>
     *description:冒泡排序
     *</p>
     * @author ex_pengbo
     * @see
     */
    public void bubbleSort() {
        for (int out=index-1;out>0;out--) {
            for (int in=0;in<out;in++) {
                if (arr[in] > arr[in+1]) {
                    swap(in,in+1);
                }
            }
        }
    }

    /**
     *
     *<p>
     *description:数据交换
     *</p>
     * @param one
     * @param two
     * @author ex_pengbo
     * @see
     */
    private void swap(int one, int two) {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;

    }

    /**
     *
     *<p>
     *description:打印数组元素
     *</p>
     * @author ex_pengbo
     * @see
     */
    public void display() {
        for (int i=0;i<index;i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
