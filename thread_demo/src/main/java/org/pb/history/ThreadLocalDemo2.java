package org.pb.history;

import java.util.Random;

public class ThreadLocalDemo2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					
					MyThreadScopeData2.getThreadInstance().setOid(data);
					MyThreadScopeData2.getThreadInstance().setName(String.valueOf(data));
					
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A {
		public void getData() {
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + MyThreadScopeData2.getThreadInstance());
		}
	}
	
	static class B {
		public void getData() {
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + MyThreadScopeData2.getThreadInstance());
		}		
	}
}

class MyThreadScopeData2 {
	private int oid;
	
	private String name;

	public int getOid() {
		return oid;
	}
	
	public static MyThreadScopeData2 getThreadInstance() {
		MyThreadScopeData2 instance = threadLocal.get();
		if (instance == null) {
			instance = new MyThreadScopeData2();
			threadLocal.set(instance);
		}
		
		return instance;
	}
	
	private static ThreadLocal<MyThreadScopeData2> threadLocal = new ThreadLocal<>();
	
	private MyThreadScopeData2() {
		
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
