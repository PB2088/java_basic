package org.pb.history;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunicationDemo {

	public static void main(String[] args) {
		
		final ConditionBusiness business = new ConditionBusiness();
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
					
						for(int i=1;i<=50;i++){
							business.sub(i);
						}
						
					}
				}
		).start();
		
		for(int i=1;i<=50;i++){
			business.main(i);
		}
		
	}

}

class ConditionBusiness {
	private boolean bShouldSub = true;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void sub(int i) {
		lock.lock();
		try {
			while (!bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("sub thread sequence of " + j + ",loop of " + i);
			}
			bShouldSub = false;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while (bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println("main thread sequence of " + j + ",loop of " + i);
			}
			bShouldSub = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
