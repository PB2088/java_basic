package org.pb.doublyLinked;

public class Link<T> {
	private T obj;
	private Link<T> previous;
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

	public Link<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Link<T> previous) {
		this.previous = previous;
	}
	
}
