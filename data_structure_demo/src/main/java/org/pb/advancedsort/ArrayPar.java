package org.pb.advancedsort;

public class ArrayPar {
	private long[] theArray;
	private int nElems;
	
	public ArrayPar(int maxSize) {
		if (maxSize<0)
			maxSize = 1;
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public int size() {
		return nElems;
	}
	
	public void display() {
		System.out.print("A=[");
		for (int i=0;i<nElems;i++) {
			System.out.print(theArray[i]+" ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public int partitionIt(int left,int right,long pivot) {
		
		int leftPtr = left;
		int rightPtr = right;
		int flag = 1;
		
		while(true) {
			while(leftPtr<rightPtr && theArray[leftPtr] < pivot)
				leftPtr++;
			
			while(rightPtr>leftPtr && theArray[rightPtr] > pivot)
				rightPtr--;
			
			if (leftPtr >= rightPtr)
				break;
			else 
				swap(leftPtr,rightPtr);
			
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
