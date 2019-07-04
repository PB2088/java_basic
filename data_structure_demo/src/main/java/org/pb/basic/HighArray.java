package org.pb.basic;

public class HighArray {
	private long[] arr;
	private int index;
	
	public HighArray(int maxSize) {
		if (maxSize<=0) {
			maxSize = 1;
		}
		arr = new long[maxSize];
		index = 0;
	}
	/**
	 * Add Array Element
	 */
	public boolean insert(long value) {
		if (index < arr.length) {
			arr[index++] = value;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete (long value) {
		if (find(value) == -1) {
			return false;
		} else {
			int k = find(value);
			for (int i=k;i<index;i++){
				arr[i] = arr[i+1];
			}
			index--;
		}
		return true;
	}
	
	public int find (long searchKey) {
		int j;
		if (index == 0) {
			return -1;
		}
		for (j=0;j<index;j++) {
			if (arr[j] == searchKey) {
				return j;
			}
		}
		return -1;
	}
	
	public void print() {
		for (int i=0;i<index;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}
