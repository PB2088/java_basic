package org.pb.app;

import org.junit.Test;
import org.pb.doublyLinked.DoublyLinkedList;
import org.pb.linklist.Person;

public class DoublyLinkedListTestApp {
	@Test
	public void doublyLinkedListTest() {
		DoublyLinkedList<Person> dLinkList = new DoublyLinkedList<Person>();
		dLinkList.insertFirst(new Person("宋江","男",42));
		dLinkList.insertFirst(new Person("吴用","男",32));
		dLinkList.insertFirst(new Person("林冲","男",31));
		dLinkList.insertFirst(new Person("扈三娘","女",27));
		dLinkList.insertFirst(new Person("杨志","男",25));
		System.out.println("----------元素删除前----------");
		dLinkList.displayList();
		System.out.println("----------元素删除后----------");
		dLinkList.deleteLinkFirst();
		dLinkList.displayList();
		System.out.println("----------插入新元素----------");
		dLinkList.insertLinkAfter("吴用", new Person("彭波","男",23));
		dLinkList.displayList();
		System.out.println("----------删除末尾元素后----------");
		dLinkList.deleteLinkLast();
		dLinkList.displayList();
		System.out.println("----------从头部插入元素----------");
		dLinkList.insertFirst(new Person("刘元","男",32));
		dLinkList.displayList();
		System.out.println("----------doublyLinkedListTest() end-------------");
	}
}
