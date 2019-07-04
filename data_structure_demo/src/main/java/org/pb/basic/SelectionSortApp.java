package org.pb.basic;

public class SelectionSortApp {
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort(20);
		selectionSort.insert(19);
		selectionSort.insert(17);
		selectionSort.insert(14);
		selectionSort.insert(25);
		selectionSort.insert(36);
		selectionSort.insert(10);
		selectionSort.insert(21);
		selectionSort.insert(48);
		selectionSort.insert(7);
		
		System.out.print("排序前：\t");
		selectionSort.display();
		System.out.println("======================================排序过程======================================");
		selectionSort.selectSort();
		System.out.println("======================================排序过程end======================================");
		System.out.print("排序后：\t");
		selectionSort.display();
	}
}
