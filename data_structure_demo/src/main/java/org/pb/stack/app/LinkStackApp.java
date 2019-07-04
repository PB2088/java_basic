package org.pb.stack.app;

import org.junit.Test;
import org.pb.linklist.Person;
import org.pb.stack.util.LinkStack;

public class LinkStackApp {
	@Test
	public void test() {
		LinkStack<Person> aStack = new LinkStack<Person>();
		aStack.push(new Person("�ν�","��",42));
		aStack.push(new Person("����","��",32));
		aStack.push(new Person("�ֳ�","��",31));
		aStack.push(new Person("������","Ů",27));
		aStack.push(new Person("��־","��",25));
		while (!aStack.isEmpty()) {
			System.out.println(aStack.pop());
		}
	}
}
