package org.pb.queue.util;

import org.pb.linklist.FirstLastList;

public class LinkQueue<T> {
	private FirstLastList<T> theFirstLastList;
	
	public LinkQueue () {
		this.theFirstLastList = new FirstLastList<T>();
	}
	
	/**
	 * 
	 *<p>
	 *description:入队操作
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void enqueue(T obj) {
		this.theFirstLastList.insertLast(obj);
	}
	
	/**
	 * 
	 *<p>
	 *description:出队操作
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public T dequeue() {
		return this.theFirstLastList.deleteFirst();
	}
	
	/**
	 * 
	 *<p>
	 *description:判断队列是否为空
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isEmpty() {
		return this.theFirstLastList.isEmpty();
	}
}
