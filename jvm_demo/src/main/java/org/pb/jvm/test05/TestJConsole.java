package org.pb.jvm.test05;

import java.util.Scanner;

public class TestJConsole {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("==================");
				}
			}
		},"while true");
	}

}
