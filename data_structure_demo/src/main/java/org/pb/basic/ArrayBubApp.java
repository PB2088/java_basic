package org.pb.basic;

public class ArrayBubApp {
	public static void main(String[] args) {
		ArrayBub arrayBub = new ArrayBub(20);
		arrayBub.insert(19);
		arrayBub.insert(17);
		arrayBub.insert(14);
		arrayBub.insert(25);
		arrayBub.insert(36);
		arrayBub.insert(10);
		arrayBub.insert(21);
		arrayBub.insert(48);
		arrayBub.insert(7);
		arrayBub.insert(33);
		arrayBub.insert(22);
		
		System.out.println("排序前：");
		arrayBub.display();
		System.out.println("排序后：");
		arrayBub.bubbleSort();
		arrayBub.display();
	}
}
