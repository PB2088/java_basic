package org.pb.stack.util;


public class StackX<T> {
	private int maxSize;
	private T[] stackArray;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackX(int size) {
		if (size <=0) {
			maxSize = 1;
		} else {
			maxSize = size;
		}
		
		stackArray =(T[]) new Object[maxSize];
		top = -1;
	}
	
	/**
	 * 
	 *<p>
	 *description:入栈
	 *</p>
	 *@param value
	 * @author ex_pengbo
	 * @see
	 */
	public void push(T value) {
		if (isFull()) {
			System.out.println("栈满不能入栈!");
			return;
		}
		stackArray[++top] = value;
	}
	
	/**
	 * 
	 *<p>
	 *description:出栈
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public T pop() {
		return stackArray[top--];
	}
	
	/**
	 * 
	 *<p>
	 *description:判断栈满
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isFull() {
		return (top == maxSize -1);
	}
	
	/**
	 * 
	 *<p>
	 *description:判断栈空
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isEmpty() {
		return (top == -1);
	}
	
	/**
	 * 
	 *<p>
	 *description:打印栈
	 *</p>
	 * @author ex_pengbo
	 * @see
	 */
	public void printStack() {
		for (int i = top;i>-1;i--) {
			System.out.println(stackArray[i]);
		}
	}
	
	/**
	 * 查看栈顶元素
	 * @return
	 */
	public T peek() {
		return stackArray[top];
	}
}
