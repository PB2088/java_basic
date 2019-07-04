package org.pb.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TriangularApp {
	@Test
	public void triangularTest() throws IOException {
		System.out.print("请输入一个整数：");
		int theNum = getInt();
		triangular(theNum);
		System.out.println(triangular(theNum));
	}
	
	public int triangular(int n) {
		if (n == 1)
			return 1;
		return n+triangular(n-1);
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
