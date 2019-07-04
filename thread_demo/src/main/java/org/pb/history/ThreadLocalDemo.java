package org.pb.history;

import java.util.Random;

public class ThreadLocalDemo {
	private static ThreadLocal<MyThreadScopeData> threadLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					
					MyThreadScopeData scopeData = new MyThreadScopeData();
					scopeData.setOid(data);
					scopeData.setName(String.valueOf(data));
					threadLocal.set(scopeData);
					
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A {
		public void getData() {
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + threadLocal.get());
		}
	}
	
	static class B {
		public void getData() {
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + threadLocal.get());
		}		
	}
}
