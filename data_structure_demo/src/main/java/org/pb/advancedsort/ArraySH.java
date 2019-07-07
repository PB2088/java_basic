package org.pb.advancedsort;

public class ArraySH {
	private long[] theArray;
	private int nElems;
	
	public ArraySH(int maxSize) {
		if (maxSize<0)
			maxSize = 1;
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public void display() {
		System.out.print("A=");
		System.out.print("[");
		for(int i=0;i<nElems;i++) {
			if (theArray[i] != 0) {
				if(i != nElems-1) 
					System.out.print(theArray[i]+ ",");
				else
					System.out.print(theArray[i]);				
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	public void shellSort() {
		int inner;
		int outer;
		long temp;
		
		int h = 1;
		//计算分组最大间隔
		while (h<nElems/3) {
            h = h * 3 + 1;
        }
		
		int flag = 1;
		
		//逐步缩小分组的间隔
		while (h>0) {
			for (outer = h;outer < nElems;outer++) {
				temp = theArray[outer];
				inner = outer;
				
				while (inner > h -1 && theArray[inner -h] >= temp) {
					theArray[inner] = theArray[inner-h];
					inner -= h;
				}
				theArray[inner] = temp;
				System.out.print("第"+(flag++)+"趟排序结果：");
				display();
			}
			h = (h-1)/3;
		}
	}
}
