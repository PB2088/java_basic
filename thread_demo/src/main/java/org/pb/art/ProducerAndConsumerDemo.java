package org.pb.art;

import org.pb.art.Consumer;
import org.pb.art.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        Producer<Integer> p1 = new Producer<Integer>(queue);
        Producer<Integer> p2 = new Producer<Integer>(queue);

        Consumer<Integer> c1 = new Consumer<Integer>(queue);
        Consumer<Integer> c2 = new Consumer<Integer>(queue);
        Consumer<Integer> c3 = new Consumer<Integer>(queue);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }

}
