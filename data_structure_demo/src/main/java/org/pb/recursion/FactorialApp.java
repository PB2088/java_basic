package org.pb.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import org.junit.Test;

public class FactorialApp {
	@Test
	public void factorialTest() throws IOException {
		System.out.print("请输入一个整数：");
		int theNum = getInt();
		System.out.println(factorial(theNum));
	}
	
	@Test
	public void factorialPlusTest() throws IOException {
		System.out.print("请输入一个整数：");
		int theNum = getInt();
		System.out.println(factorialPlus(BigInteger.valueOf(theNum)));
	}
	
	public long factorial(int n) {
		if (n == 1)
			return 1;
		return n*factorial(n-1);
	}
	
	public BigInteger factorialPlus(BigInteger n) {
		if (n.intValue() == 1) {
			return BigInteger.ONE;
		}
		return n.multiply(factorialPlus(n.subtract(BigInteger.ONE)));
	}
	
	private int getInt() throws IOException {
		return Integer.valueOf(getString());
	}

	
	private String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
}
