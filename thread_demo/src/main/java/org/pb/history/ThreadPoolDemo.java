package org.pb.history;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		/*
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i ++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of  " + j
								+ " for task of " + task);
					}
				}	
			});
		}
		
		threadPool.shutdown();
		*/
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 2, TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing~bombing!");
				
			}
		}, 5, 2, TimeUnit.SECONDS);
	}
}
