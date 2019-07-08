package org.pb.advancedsort;

import java.util.Random;

public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayShell arraySH = new ArrayShell(maxSize);
/*		arraySH.insert(23);
		arraySH.insert(91);
		arraySH.insert(45);
		arraySH.insert(19);
		arraySH.insert(12);
		arraySH.insert(51);
		arraySH.insert(70);
		arraySH.insert(37);
		arraySH.insert(33);
		arraySH.insert(21);*/
		Random random = new Random();
		for (int i=0;i<maxSize;i++) {
			arraySH.insert(random.nextInt(100));
		}
				
		System.out.print("Before Sort:");
		arraySH.display();
		long startTime = System.currentTimeMillis();
		arraySH.shellSort();
		long endTime = System.currentTimeMillis();
		System.out.println("排序耗时："+(endTime-startTime));
		System.out.print("After Sort:");
		arraySH.display();
	}
}
