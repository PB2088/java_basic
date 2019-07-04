package org.pb.jvm.test02;

public class Main {
	private Main obj;
	
	public void setObj(Main obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		Main m1 = new Main();
		Main m2 = new Main();
		
		m1.setObj(m2);
		m2.setObj(m1);
		
		m1 = null;
		m2 = null;
		
		System.gc();
	}
}
