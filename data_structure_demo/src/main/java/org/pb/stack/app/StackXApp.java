package org.pb.stack.app;

import org.pb.stack.util.StackX;

public class StackXApp {

	/**
	 *<p>
	 *description:
	 *</p>
	 *@param args
	 * @author ex_pengbo
	 * @see
	 */
	public static void main(String[] args) {
		StackX a_stack = new StackX(10);
		a_stack.push(20);
		a_stack.push(17);
		a_stack.push(32);
		a_stack.push(10);
		a_stack.push(27);
		a_stack.push(45);
		
		//查看栈顶元素
		System.out.println(a_stack.peek());
		
		//输出栈的全部元素
		a_stack.printStack();
	}

}
