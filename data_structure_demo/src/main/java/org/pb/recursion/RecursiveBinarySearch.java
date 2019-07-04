package org.pb.recursion;

import org.junit.Before;
import org.junit.Test;

public class RecursiveBinarySearch {
	private long[] arr;
	private int nElems;
	private final static int MAX_SIZE = 100;
	
	@Before
	public void setUp() {
		arr = new long[MAX_SIZE];
		nElems = 0;
	}
	
	public void insert(long value) {
		int i = findGreaterThanValue(value);
		for (int k=nElems;k>i;k--) {
			arr[k] = arr[k-1];
		}
		arr[i] = value;
		nElems ++;
	}

	private int findGreaterThanValue(long value) {
		for (int i=0;i<nElems;i++)
			if (arr[i]>value)
				return i;
		return nElems;
	}
	
	public int find(long keyWord) {
		//return binarySearch(keyWord);
		return recursiveBinarySearch(keyWord,0,nElems-1);
	}
	
	
	@SuppressWarnings("unused")
	private int binarySearch(long keyWord) {
		int lowerBound = 0;
		int upperBound = nElems -1;
		int curIn;
		while (true) {
			curIn = (lowerBound + upperBound)/2;
			if (arr[curIn]==keyWord)
				return curIn;
			else if (lowerBound >= upperBound)
				return -1;
			else {
				if (arr[curIn]>keyWord)
					upperBound = curIn - 1;
				if (arr[curIn] < keyWord)
					lowerBound = curIn + 1;
			}
			
		}
	}
	
	private int recursiveBinarySearch(long keyWord,int lowerBound,int upperBound) {
		int curIn = (lowerBound+upperBound)/2;
		if (arr[curIn]==keyWord) 
			return curIn;
		if (lowerBound >= upperBound)
			return -1;
		else {
			if (arr[curIn]>keyWord)
			return recursiveBinarySearch(keyWord,lowerBound,curIn - 1);
			else
			return recursiveBinarySearch(keyWord,lowerBound,upperBound);
		}
	}

	public void display() {
		for(int i=0;i<nElems;i++)
			System.out.print(arr[i]+"  ");
		System.out.println("");
	}
	
	@Test
	public void recursiveBinarySearchTest() {
		insert(24);
		insert(17);
		insert(87);
		insert(53);
		insert(99);
		insert(11);
		insert(10);
		insert(20);
		insert(32);
		display();
		insert(27);
		display();
		int idex = find(24);
		System.out.println("����24��λ�ã�"+(idex==-1?"�����в�����24!":(idex+1)));
	}
}
