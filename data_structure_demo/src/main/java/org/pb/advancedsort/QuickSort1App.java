package org.pb.advancedsort;

import java.util.Random;

public class QuickSort1App {

	public static void main(String[] args) {
		int maxSize = 8;
		ArrayIns arrayIns = new ArrayIns(maxSize);
		Random random = new Random();
		for (int i=0;i<maxSize;i++) {
			arrayIns.insert(random.nextInt(150));
		}
		arrayIns.display();
		
		arrayIns.quickSort();
		
		arrayIns.display();
	}

}
