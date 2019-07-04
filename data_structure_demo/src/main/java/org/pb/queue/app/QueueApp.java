package org.pb.queue.app;

import org.pb.queue.util.QueueX;

public class QueueApp {
	public static void main(String[] args) {
		QueueX<Long> queueX = new QueueX<Long>(10);
		
		queueX.enqueue(10L);
		queueX.enqueue(20L);
		queueX.enqueue(30L);
		queueX.enqueue(40L);
		queueX.enqueue(50L);
		queueX.enqueue(60L);
		queueX.enqueue(70L);
		
		queueX.dequeue();
		queueX.dequeue();
		queueX.dequeue();
		
		queueX.enqueue(55L);
		queueX.enqueue(67L);
		queueX.enqueue(74L);
		queueX.enqueue(88L);
		
		queueX.printQueue();		
	}
}
