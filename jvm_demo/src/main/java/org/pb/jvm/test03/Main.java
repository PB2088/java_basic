package org.pb.jvm.test03;

public class Main {
	
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) {

/*		byte[] allocation1 = new byte[_1MB * 2];
		byte[] allocation2 = new byte[_1MB * 2];
		byte[] allocation3 = new byte[_1MB * 2];*/
		byte[] allocation4 = new byte[_1MB * 8]; //出现一次MinorGC
		
		
	}
}
