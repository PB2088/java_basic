package org.pb.advancedsort;

public class ArrayIns2 {
	private long[] theArray;
	private int nElems;
	
	public ArrayIns2(int maxSize) {
		if (maxSize<0)
			maxSize = 1;
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public void display() {
		System.out.print("A=[");
		for (int i=0;i<nElems;i++) {
			System.out.print(theArray[i]+" ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public void quickSort() {
		recQuickSort(0,nElems-1);
	}

	private void recQuickSort(int left, int right) {
		if (right <= left)
			return;
		
		long pivot = medianOf3(left,right);
		
		int partition = partitionIt(left, right, pivot);
		display();
		
		recQuickSort(0,partition-1);
		recQuickSort(partition+1,right);
	}
	

	private long medianOf3(int left, int right) {
		int center = (left+right)/2;
		
		if (theArray[left]>theArray[center])
			swap(left, center);
		
		if (theArray[left]>theArray[right])
			swap(left, right);
		
		if (theArray[center]>theArray[right])
			swap(center, right);
		
		swap(center, right-1);
		return theArray[right-1];
	}

	private int partitionIt(int left, int right, long pivot) {

		int leftPtr = left;
		int rightPtr = right-1;
		int flag = 1;

		while (true) {
			while (theArray[leftPtr] < pivot)
				leftPtr++;

			while (theArray[rightPtr] > pivot)
				rightPtr--;

			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
			System.out.print("第"+(flag++)+"趟排序结果：");
			display();
		}
		return leftPtr;
	}
	
	private void swap(int leftPtr, int rightPtr) {
		long temp;
		temp = theArray[leftPtr];
		theArray[leftPtr] = theArray[rightPtr];
		theArray[rightPtr] = temp;
	}
}
