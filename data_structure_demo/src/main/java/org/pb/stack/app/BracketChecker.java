package org.pb.stack.app;

import org.pb.stack.util.StackX;

public class BracketChecker {
	private String inputStr;
	
	public BracketChecker(String inputStr) {
		this.inputStr = inputStr;
	}
	
	public void check() {
		StackX<Character> stackX = new StackX<Character>(inputStr.length());
		
		for (int i=0;i<inputStr.length();i++) {
			char ch = inputStr.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stackX.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!stackX.isEmpty()) {
					char chX = stackX.pop();
					if ( (ch == '}' && chX != '{') ||
						 (ch == ')' && chX != '(') ||
						 (ch == ']' && chX != '[')
					) {
						System.out.println("错误信息：第"+(i+1)+"个'"+ch+"'括号没有匹配!");
					}
				} else {
					System.out.println("错误信息：第"+(i+1)+"个"+ch+"括号没有匹配!");
				}
			default:
				break;
			}
		}
		if (!stackX.isEmpty()) {
			System.out.println("错误信息：缺少正确的分隔符!");
		}
	}
	public static void main(String[] args) {
		BracketChecker theBracketCh = new BracketChecker("a{bcad}c[aa]aaa(6376){11");
		theBracketCh.check();
	}
}
