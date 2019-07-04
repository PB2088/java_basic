package org.pb.app;

import org.pb.stack.util.StackX;

public class InToPost {
	private StackX<Character> stackX;
	private String input;
	private String output = "";
	
	public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		stackX = new StackX<Character>(stackSize);
	}
	
	public String doTrans() {
		for (int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				getOpr(ch,1);
				break;
			case '*':
			case '/':
				getOpr(ch,2);
				break;
			case '(':
				stackX.push(ch);
				break;
			case ')':
				gotParen();
				break;
			default:
				output += ch;
				break;
			}
		}
		
		while (!stackX.isEmpty()) {
			output += stackX.pop();
		}
		return output;
	}

	private void gotParen() {
		while (!stackX.isEmpty()) {
			char chX = stackX.pop();
			if (chX == '(') {
				break;
			} else {
				output += chX;
			}
		}
	}

	private void getOpr(char opThis, int prec1) {
		while (!stackX.isEmpty()) {
			char opTop = stackX.pop();
			if (opTop == '(') {
				stackX.push(opTop);
				break;
			} else {
				int prec2 = (opTop == '+' || opTop == '-')?1:2;
				if (prec2 < prec1) {
					stackX.push(opTop);
					break;
				} else {
					output += opTop;
				}
			}
		}
		stackX.push(opThis);
	}
}
