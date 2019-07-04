package org.pb.linklist;

public class FirstLastList<T> {
	private Link<T> first;
	private Link<T> last;
	public FirstLastList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	/**
	 * 
	 *<p>
	 *description:从表头插入元素
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertFirst(T obj) {
		Link<T> newLink = new Link<T>(obj);
		
		if (isEmpty())
			last = newLink;
		newLink.setNext(first);
		first = newLink;
	}
	
	/**
	 * 
	 *<p>
	 *description:从表头删除元素
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public T deleteFirst() {
		if (first.getNext() == null)
			last = null;
		Link<T> temp = first;
		first = first.getNext();
		return temp.getObj();
	}
	
	/**
	 * 
	 *<p>
	 *description:从表尾插入元素
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertLast(T obj) {
		Link<T> newLink = new Link<T>(obj);
		
		if (isEmpty()) {
			first = newLink;
			last = newLink;
		}
		last.setNext(newLink);
		last = newLink;
	}
	
	
	/**
	 * 
	 *<p>
	 *description:显示链表元素
	 *</p>
	 * @author ex_pengbo
	 * @see
	 */
	public void displayList() {
		Link<T> current = first;
		while (current != null) {
			System.out.println(current.getObj());
			current = current.getNext();
		}
	}
}
