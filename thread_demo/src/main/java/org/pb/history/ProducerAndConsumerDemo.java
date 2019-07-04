package org.pb.history;

import org.pb.thread.Consumer;
import org.pb.thread.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerDemo {
	public static void main(String[] args) {
	     BlockingQueue<Integer> q = new ArrayBlockingQueue<>(1);
	     Producer<Integer> p = new Producer<Integer>(q);
	     Consumer<Integer> c1 = new Consumer<Integer>(q);
	     Consumer<Integer> c2 = new Consumer<Integer>(q);
	     Consumer<Integer> c3 = new Consumer<Integer>(q);
	     
	     new Thread(p).start();
	     new Thread(c1).start();
	     new Thread(c2).start();
	     new Thread(c3).start();

	}

}
