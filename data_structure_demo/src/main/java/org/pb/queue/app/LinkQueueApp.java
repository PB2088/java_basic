package org.pb.queue.app;

import org.junit.Test;
import org.pb.linklist.Person;
import org.pb.queue.util.LinkQueue;

public class LinkQueueApp {
	@Test
	public void test() {
		LinkQueue<Person> aLinkQueue = new LinkQueue<Person>();
		aLinkQueue.enqueue(new Person("宋江","男",42));
		aLinkQueue.enqueue(new Person("吴用","男",32));
		aLinkQueue.enqueue(new Person("林冲","男",31));
		aLinkQueue.enqueue(new Person("扈三娘","女",27));
		aLinkQueue.enqueue(new Person("杨志","男",25));
		while (!aLinkQueue.isEmpty()) {
			System.out.println(aLinkQueue.dequeue());
		}
	}
}
