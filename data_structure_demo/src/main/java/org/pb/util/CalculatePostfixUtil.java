package org.pb.util;

import org.pb.stack.util.StackX;

/**
 * @author bo.peng
 * @create 2019-06-15
 */
public class CalculatePostfixUtil {
	private StackX<Integer> theStack;
	private String postfixStr;
	
	public CalculatePostfixUtil(String postfix) {
		this.postfixStr = postfix;
		int stackSize = (postfixStr == null || postfixStr.length() == 0)?1:postfixStr.length();
		theStack = new StackX<Integer>(stackSize);
	}
	
	public Integer doCalculate() throws Exception {
		if (CommonFunctions.isEmpty(postfixStr)) {
			throw new Exception("后缀表达式为空!");
		}
		
		char[] postfixCharArray = postfixStr.toCharArray();
		
		for (int i=0;i<postfixCharArray.length;i++) {
			char ch = postfixCharArray[i];
			Integer temp = null;
			switch (ch) {
			case '+':
				temp = add();
				break;
			case '-':
				temp = sub();
				break;
			case '*':
				temp = mul();
				break;
			case '/':
				temp = div();
				break;				
			default:
				theStack.push((Integer)(ch-'0'));
				break;
			}
			if (temp != null) {
				theStack.push(temp);
			}
		}
		return theStack.pop();
	}

	private Integer div() {
		Integer first = theStack.pop();
		Integer second = theStack.pop();
		return second/first;
	}

	private Integer mul() {
		Integer first = theStack.pop();
		Integer second = theStack.pop();
		return first*second;
	}

	private Integer sub() {
		Integer first = theStack.pop();
		Integer second = theStack.pop();
		return second-first;
	}

	private Integer add() {
		Integer first = theStack.pop();
		Integer second = theStack.pop();
		return first+second;
	}
}
