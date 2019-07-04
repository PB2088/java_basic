package org.pb.history;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		
		Outputer outputer = new Outputer();
		
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				outputer.output("zhangxiaoxiang");
			}
		}).start();
		
		new Thread(() -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			outputer.output("lihuoming");			
		}).start();
		
	}
}

class Outputer {
	Lock lock = new ReentrantLock();
	public void output(String name) {
		int len = name.length();
		lock.lock();
		try {
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			
			System.out.println();
		} finally {
			lock.unlock();
		}
	}
}
