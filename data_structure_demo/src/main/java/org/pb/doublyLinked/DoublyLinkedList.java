package org.pb.doublyLinked;

public class DoublyLinkedList<T> {
	private Link<T> first;
	private Link<T> last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	/**
	 * 
	 *<p>
	 *description:判断链表是否为空
	 *</p>
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 
	 *<p>
	 *description:从链表头部插入数据
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertFirst(T obj) {
		Link<T> newLink = new Link<T>(obj);
		if (isEmpty())
			last = newLink;
		else 
			first.setPrevious(newLink);
		newLink.setNext(first);
		first = newLink;
	}
	
	/**
	 * 
	 *<p>
	 *description:从链表尾部插入数据
	 *</p>
	 *@param obj
	 * @author ex_pengbo
	 * @see
	 */
	public void insertLast(T obj) {
		Link<T> newLink = new Link<T>(obj);
		if (isEmpty()) 
			first = newLink;
		else {
			newLink.setPrevious(last);
			last.setNext(newLink);
		}
		last = newLink;
	}
	
	/**
	 * 
	 *<p>
	 *description:指定节点插入元素
	 *</p>
	 *@param keyWord
	 *@param obj
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean insertLinkAfter(Object keyWord,T obj) {
		Link<T> current = getCurrentLinkByKeyWord(keyWord);
		if (current == null) 
			return false;
		
		Link<T> newLink = new Link<T>(obj);
		if (current == last) {
			newLink.setNext(null);
			last = newLink;
		} else {
			newLink.setNext(current.getNext());
			current.getNext().setPrevious(newLink);
		}
		newLink.setPrevious(current);
		current.setNext(newLink);
		return true;
	}
	
	/**
	 * 
	 *<p>
	 *description:根据关键字查找链表节点
	 *</p>
	 *@param keyWord
	 *@return
	 * @author ex_pengbo
	 * @see
	 */
	public Link<T> getCurrentLinkByKeyWord(Object keyWord) {
		Link<T> current = first;
		 while (current != null) {
			 String infoStr = current.getObj().toString();
			 if (infoStr.indexOf(keyWord.toString()) != -1) {
				 break;
			 }
			 current = current.getNext();
		 }
		 return current;
	}
	
	public Link<T> deleteLinkFirst() {
		Link<T> temp = first;
		if (isEmpty())
			return null;
		
		if (first.getNext() == null)
			last = null;
		else 
			first.getNext().setPrevious(null);
		
		first = first.getNext();
		return temp;
	}
	
	public Link<T> deleteLinkLast() {
		Link<T> temp = last;
		if (isEmpty())
			return null;
		
		if (first.getNext() == null)
			first = null;
		else
			last.getPrevious().setNext(null);
		last = last.getPrevious();
		return temp;
	}
	
	public boolean deleteLinkByKeyWord(Object keyWord) {
		Link<T> current = getCurrentLinkByKeyWord(keyWord);
		if (current != null) {
			if (current == first) {
				first.getNext().setPrevious(null);
				first = first.getNext();
			} else {
				current.getPrevious().setNext(current.getNext());
			}
			
			if (current == last) {
				last = current.getPrevious();
				current.getPrevious().setNext(null);
			} else {
				current.getNext().setPrevious(current.getPrevious());
			}
			
			
			return true;
		} else {
			return false;
		}
	}
	
	public void displayList() {
		Link<T> current = first;
		while (current != null) {
			System.out.print(current.getObj()+ " ");
			current = current.getNext();
		}
		System.out.println();
	}
}
