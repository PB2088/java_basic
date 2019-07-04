package org.pb.stack.util;

public class LinkStack<T> {
	private LinkList<T> theLinkList;
	
	public LinkStack(){
		this.theLinkList = new LinkList<T>();
	}
	
	/**
	 * 
	 *<p>
	 *description:???????
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void push(T obj) {
		theLinkList.insertFirst(obj);
	}
	
	/**
	 * 
	 *<p>
	 *description:???????
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public T pop() {
		return theLinkList.deleteFirst();
	}
	
	/**
	 * 
	 *<p>
	 *description:?ж????
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isEmpty() {
		return theLinkList.isEmpty();
	}
}
