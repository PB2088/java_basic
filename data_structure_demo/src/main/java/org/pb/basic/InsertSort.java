package org.pb.basic;

public class InsertSort {
	private long[] arr;
	private int nElems;
	
	public InsertSort(int maxSize) {
		if (maxSize < 0) {
			maxSize = 1;
		}
		arr = new long[maxSize];
		nElems = 0;
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
		if (nElems < arr.length) {
			arr[nElems++] = value;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 *<p>
	 *description:插入排序
	 *</p>
	 * @author ex_pengbo
	 * @see
	 */
	public void insertSort() {
		
		for (int out =1;out<nElems;out++) {
			long temp = arr[out];
			int in = out;
			
			while(in>0 && arr[in-1] >= temp) {
				arr[in] = arr[in-1];
				--in;
			}
			arr[in] = temp;
		}
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
		for (int i=0;i<nElems;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}	
}
