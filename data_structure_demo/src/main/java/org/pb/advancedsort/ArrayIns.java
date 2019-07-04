package org.pb.advancedsort;

public class ArrayIns {
	private long[] theArray;
	private int nElems;
	
	public ArrayIns(int maxSize) {
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
		
		long pivot = theArray[right];
		
		int partition = partitionIt(left, right, pivot);
		display();
		
		recQuickSort(0,partition-1);
		recQuickSort(partition+1,right);
	}
	

	private int partitionIt(int left, int right, long pivot) {

		int leftPtr = left;
		int rightPtr = right;
		int flag = 1;

		while (true) {
			while (theArray[leftPtr] < pivot)
				leftPtr++;

			while (rightPtr > leftPtr && theArray[rightPtr] > pivot)
				rightPtr--;

			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
			System.out.print("第"+(flag++)+"趟划分结果：");
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
