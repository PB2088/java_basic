package org.pb.linklist;

public class LinkList<T> {
	private Link<T> first;

	public LinkList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 
	 *<p>
	 *description:从链表头部插入链表元素
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertFirst(T obj) {
		Link<T> nextLink = new Link<T>(obj);
		nextLink.setNext(first);
		first = nextLink;
	}
	
	/**
	 * 
	 *<p>
	 *description:从链表末尾插入链表元素
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertAfter(T obj) {
		if (first == null) {			
			first = new Link<T>(obj);
			return;
		}
		Link<T> endLink = first;
		while (endLink != null) {
			if (endLink.getNext() == null) {
				break;
			}
			endLink = endLink.getNext();
		}
		endLink.setNext(new Link<T>(obj));
	}
	
	/**
	 * 
	 *<p>
	 *description:根据关键字删除链表节点
	 *</p>
	 *@param keyWord
	 * @author ex_pengbo
	 * @see
	 */
	public void deletByKeyWord(Object keyWord) {
		Link<T> current = first;
		while (current != null) {
			String infoStr = current.getObj().toString();
			if (infoStr.indexOf(keyWord.toString()) != -1) {
				Link<T> previous = getPreviousLink(current);
				if (previous == null) {
					first = current.getNext();
				} else {
					previous.setNext(current.getNext());
				}
			}
			current = current.getNext();
		}
	}
	
	/**
	 * 
	 *<p>
	 *description:获取当前链接元素的前一个元素
	 *</p>
	 *@param current
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	private Link<T> getPreviousLink(Link<T> current) {
		Link<T> previous = first;
		if (first == current) {
			return null;
		}
		while (previous != null) {
			if (previous.getNext() == current) {
				break;
			}
			previous = previous.getNext();
		}
		return previous;
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
