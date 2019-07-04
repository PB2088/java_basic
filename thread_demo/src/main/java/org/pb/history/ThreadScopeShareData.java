package org.pb.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
	private static Map<Thread, Integer> threadMap = new HashMap<>();
	public static void main(String[] args) {
		
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					
					threadMap.put(Thread.currentThread(), data);
					
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A {
		public void getData() {
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + threadMap.get(Thread.currentThread()));
		}
	}
	
	static class B {
		public void getData() {
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + threadMap.get(Thread.currentThread()));
		}		
	}
}

class MyThreadScopeData {
	private int oid;
	
	private String name;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyThreadScopeData [oid=" + oid + ", name=" + name + "]";
	}
	
}
