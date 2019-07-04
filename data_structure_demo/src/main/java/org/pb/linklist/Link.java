package org.pb.linklist;

public class Link<T> {
	private T obj;
	private Link<T> next;
		
	public Link() {
	}
	
	public Link(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}

	public Link<T> getNext() {
		return next;
	}

	public void setNext(Link<T> next) {
		this.next = next;
	}
	
}
