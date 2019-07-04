package org.pb.advancedsort;

import java.util.Random;

public class QuickSort2App {

	public static void main(String[] args) {
		int maxSize = 8;
		ArrayIns2 arrayIns2 = new ArrayIns2(maxSize);
		Random random = new Random();
		for (int i=0;i<maxSize;i++) {
			arrayIns2.insert(random.nextInt(150));
		}
		arrayIns2.display();
		
		arrayIns2.quickSort();
		
		arrayIns2.display();
	}

}
