package org.pb.stack.app;

import org.junit.Test;
import org.pb.linklist.Person;
import org.pb.stack.util.LinkStack;

public class LinkStackApp {
	@Test
	public void test() {
		LinkStack<Person> aStack = new LinkStack<Person>();
		aStack.push(new Person("宋江","男",42));
		aStack.push(new Person("吴用","男",32));
		aStack.push(new Person("林冲","男",31));
		aStack.push(new Person("扈三娘","女",27));
		aStack.push(new Person("杨志","男",25));
		while (!aStack.isEmpty()) {
			System.out.println(aStack.pop());
		}
	}
}
