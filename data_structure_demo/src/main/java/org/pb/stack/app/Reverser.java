package org.pb.stack.app;

import org.pb.stack.util.StackX;

public class Reverser {
	private String inputStr;
	private String outputStr;
	
	public Reverser(String inputStr) {
		this.inputStr = inputStr;
		this.outputStr = "";
	}
	
	public String doRev() {
		//初始化栈大小
		StackX stackX = new StackX(inputStr.length());
		
		//入栈
		for(int i=0;i<inputStr.length();i++) {
			char ch = inputStr.charAt(i);
			stackX.push(ch);
		}
		
		//出栈操作
		while (!stackX.isEmpty()) {
			outputStr+=stackX.pop();
		}
		return this.outputStr;
	}
}
