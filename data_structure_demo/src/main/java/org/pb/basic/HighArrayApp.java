package org.pb.basic;

public class HighArrayApp {
	public static void main(String[] args) {
		HighArray highArray = new HighArray(20);
		highArray.insert(22);
		highArray.insert(17);
		highArray.insert(25);
		highArray.insert(37);
		highArray.insert(8);
		highArray.insert(66);
		System.out.println("删除元素前:");
		highArray.print();
		highArray.delete(25);
		System.out.println("删除元素25后:");
		highArray.print();
		System.out.println("删除元素8后:");
		highArray.delete(8);
		highArray.print();
	}
}
