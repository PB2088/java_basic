package org.pb.recursion;

/**
 * 演示用递归来解决汉诺截问题
 * @author Administrator
 *
 */
public class Towers {
	/**
	 * 
	 * @param topN 汉诺塔的块数
	 * @param src 要移动的汉诺塔的块所在的塔
	 * @param temp 用来辅助移动
	 * @param dest 要移动的汉诺塔的目标塔
	 */
	public static void transfer(int topN,String src,String temp,String dest) {
		if (topN == 1) {
			System.out.println(topN + " 从" + src + "移动到" + dest);
		} else {
			//把topN-1当作一个整体移动到辅助塔上
			transfer(topN-1, src, dest, temp);
			
			//把topN移动到目标塔上(dest)
			System.out.println(topN + " 从" + src + "移动到" + dest);
			
			//把topN-1移动到dest
			transfer(topN-1, temp, src, dest);
		}
	}
	
	public static void main(String[] args) {
		Towers.transfer(3, "A", "B", "C");
	}
}
