package org.pb.doublyLinked;

public class DoublyLinkedListApp {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		
		dll.insertFirst(1);
		dll.insertFirst(2);
		dll.insertFirst(3);
		
		dll.displayList();
		System.out.println("=====================");
		
		dll.insertLast(4);
		dll.insertLast(5);
		dll.insertLast(6);
		
		dll.displayList();
		
		dll.deleteLinkFirst();
		System.out.println("=====================");
		
		dll.displayList();
		
		System.out.println("=====================");
		
		dll.deleteLinkLast();
		dll.displayList();
		System.out.println("=====================");
		dll.deleteLinkByKeyWord(4);
		dll.displayList();
	}
}
