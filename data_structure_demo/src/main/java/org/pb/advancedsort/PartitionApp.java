package org.pb.advancedsort;

import java.util.Random;

public class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayPar arrayPar = new ArrayPar(maxSize);
		Random random = new Random();
		for (int i=0;i<maxSize;i++) {
			arrayPar.insert(random.nextInt(150));
		}
		arrayPar.display();
		
		long pivot = 57;
		int size = arrayPar.size();
		
		int partDex = arrayPar.partitionIt(0, size-1, pivot);
		
		System.out.println("Pivot is "+pivot+",Partition is at index "+partDex);
		arrayPar.display();
		
	}
}
