package org.pb.app;

import org.junit.Test;
import org.pb.doublyLinked.DoublyLinkedList;
import org.pb.linklist.Person;

public class DoublyLinkedListTestApp {
	@Test
	public void doublyLinkedListTest() {
		DoublyLinkedList<Person> dLinkList = new DoublyLinkedList<Person>();
		dLinkList.insertFirst(new Person("�ν�","��",42));
		dLinkList.insertFirst(new Person("����","��",32));
		dLinkList.insertFirst(new Person("�ֳ�","��",31));
		dLinkList.insertFirst(new Person("������","Ů",27));
		dLinkList.insertFirst(new Person("��־","��",25));
		System.out.println("----------Ԫ��ɾ��ǰ----------");
		dLinkList.displayList();
		System.out.println("----------Ԫ��ɾ����----------");
		dLinkList.deleteLinkFirst();
		dLinkList.displayList();
		System.out.println("----------������Ԫ��----------");
		dLinkList.insertLinkAfter("����", new Person("��","��",23));
		dLinkList.displayList();
		System.out.println("----------ɾ��ĩβԪ�غ�----------");
		dLinkList.deleteLinkLast();
		dLinkList.displayList();
		System.out.println("----------��ͷ������Ԫ��----------");
		dLinkList.insertFirst(new Person("��Ԫ","��",32));
		dLinkList.displayList();
		System.out.println("----------doublyLinkedListTest() end-------------");
	}
}
