package org.pb.jvm;

import java.util.concurrent.*;

/**
 * @author boge.peng
 * @create 2019-04-14 13:44
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(100);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0;i<500;i++) {
            Producer producer = new Producer(queue);
            service.execute(producer);
        }

        for (int i = 0;i<200;i++) {
            Consumer consumer = new Consumer(queue);
            service.execute(consumer);
        }
    }
}
