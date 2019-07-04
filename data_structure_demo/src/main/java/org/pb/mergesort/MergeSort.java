package org.pb.mergesort;

public class MergeSort {

	
	public void mergeSort(long[] theArray) {
		long[] workSpace = new long[theArray.length];
		
		recMergeSort(theArray,workSpace,0,theArray.length -1);
	}
	
	private void recMergeSort(long[] theArray, long[] workSpace, int lowerBound, int highBound) {
		if (lowerBound == highBound) {
			return;
		} else {
			int mid = (lowerBound + highBound)/2;
			
			//排序左边的数据
			recMergeSort(theArray, workSpace, lowerBound, mid);
			
			recMergeSort(theArray, workSpace, mid+1, highBound);
			
			merge(theArray,workSpace,lowerBound,mid+1,highBound);
			
		}
	}

	private void merge(long[] theArray, long[] workSpace,int lowerIndex, int highIndex, int highBound) {
		//最后合并到workSpace的索引记录
		int count = 0;
		//记录左边的最大索引边界
		int mid = highIndex -1;
		//记录左边的最小索引边界
		int lowerBound = lowerIndex;
		//1:从左边依次取值跟右边的数据依次比较
		while (lowerIndex <= mid && highIndex <= highBound) {
			if (theArray[lowerIndex] < theArray[highIndex]) {
				workSpace[count++] = theArray[lowerIndex++];
			} else {
				workSpace[count++] = theArray[highIndex++];
			}
		}
		
		//2.分别处理两边还剩下的数据
		//2.1：处理左边还剩下的数据
		while (lowerIndex <= mid) {
			workSpace[count++] = theArray[lowerIndex++];
		}
		
		//2.2:处理右边还剩下的数据
		while (highIndex <= highBound) {
			workSpace[count++] = theArray[highIndex++];
		}
		
/*		System.out.println("================");
		display(workSpace);
		
		System.out.println("================");*/
		//3.把排好顺序的数据,重新拷贝回theArray
		//System.arraycopy(workSpace, 0, theArray, 0, (highBound-lowerBound+1));
		
		for (int i=0;i<(highBound-lowerBound+1);i++) {
			theArray[lowerBound+i] = workSpace[i];
		}
	}

	public void display(long[] arr) {
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		
		long[] arr = {5,7,3,8,2,4,1,6,9};
		
		ms.mergeSort(arr);
		
		ms.display(arr);
	}
}
