package org.pb.basic;

public class InsertSortApp {
	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort(20);
		insertSort.insert(19);
		insertSort.insert(17);
		insertSort.insert(14);
		insertSort.insert(25);
		insertSort.insert(36);
		insertSort.insert(10);
		insertSort.insert(21);
		insertSort.insert(48);
		insertSort.insert(7);
		
		System.out.print("排序前：\t");
		insertSort.display();
		System.out.print("排序后：\t");
		insertSort.insertSort();
		insertSort.display();
	}
}
