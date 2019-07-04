package org.pb.queue.app;

import org.pb.queue.util.PriorityQueue;


public class PriorityQueueApp {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(20);
		
		pq.enqueue(4);
		pq.enqueue(3);
		pq.enqueue(9);
		pq.enqueue(2);
		pq.enqueue(6);
		
		pq.enqueue(5);
		
		pq.enqueue(1);
		pq.enqueue(7);
		
		pq.printQueue();
	}
}
