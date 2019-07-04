package org.pb.basic;

public class SelectionSort {
	private long[] arr;
	private int index;
	
	public SelectionSort(int maxSize) {
		if (maxSize < 0) {
			maxSize = 1;
		}
		arr = new long[maxSize];
		index = 0;
	}
	
	/**
	 * 
	 *<p>
	 *description:向数组中插入元素
	 *</p>
	 *@param value
	 *@return
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
	 *description:选择排序
	 *</p>
	 * @author ex_pengbo
	 * @see
	 */
	public void selectSort() {
		int out;
		int in;
		int min;
		for(out = 0;out<index-1;out++) {
			min = out;
			for (in = out+1;in <index;in++) {
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(out,min);
			
			System.out.print("第"+(out+1)+"趟：\t");
			display();
		}
	}

	private void swap(int out, int min) {
		long temp = arr[out];
		arr[out] = arr[min];
		arr[min] = temp;
	}
	
	/**
	 * 
	 *<p>
	 *description:输出数组元素
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
