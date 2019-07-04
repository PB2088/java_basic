package org.pb.history;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadConditionCommunicationDemo {

	public static void main(String[] args) {
		
		final MultiThreadConditionBusiness business = new MultiThreadConditionBusiness();
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
					
						for(int i=1;i<=50;i++){
							business.sub2(i);
						}
						
					}
				}
		).start();
		
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
					
						for(int i=1;i<=50;i++){
							business.sub3(i);
						}
						
					}
				}
		).start();
		
		for(int i=1;i<=50;i++){
			business.main(i);
		}
		
	}

}

class MultiThreadConditionBusiness {
	private int shouldSub = 1;
	final Lock lock = new ReentrantLock();
	
	final Condition mainCondition = lock.newCondition();
	final Condition sub2Condition = lock.newCondition();
	final Condition sub3Condition = lock.newCondition();

	public void sub2(int i) {
		lock.lock();
		try {
			while (shouldSub != 2) {
				try {
					sub2Condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("sub2 thread sequence of " + j + ",loop of " + i);
			}
			shouldSub = 3;
			sub3Condition.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void sub3(int i) {
		lock.lock();
		try {
			while (shouldSub != 3) {
				try {
					sub3Condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 20; j++) {
				System.out.println("sub3 thread sequence of " + j + ",loop of " + i);
			}
			shouldSub = 1;
			mainCondition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while (shouldSub != 1) {
				try {
					mainCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println("main thread sequence of " + j + ",loop of " + i);
			}
			shouldSub = 2;
			sub2Condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
