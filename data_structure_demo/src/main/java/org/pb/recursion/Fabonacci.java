package org.pb.recursion;

public class Fabonacci {

	/**
	 * 求指定项的数据
	 * @param num
	 * @return
	 */
	public static long getN(long num) {
		
		if (num == 1) {
			return 0;
		} else if (num == 2) {
			return 1;
		}
		
		return getN(num-1) + getN(num-2);
	}
	

	/**
	 * 求第一项到指定项的和
	 * @param num
	 * @return
	 */
	public static long sum(long num) {
		if (num == 1) {
			return 0;
		}
		
		return getN(num) + sum(num-1);
	}
	
	public static void main(String[] args) {
		System.out.println(Fabonacci.getN(8));
		System.out.println(Fabonacci.sum(8));
	}
}
