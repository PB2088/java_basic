package org.pb.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer<E> implements Runnable {

    private final BlockingQueue<E> queue;

    public Producer(BlockingQueue<E> q) {
        queue = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("当前"+Thread.currentThread().getName()+" 生产者正在生产数据……");
                E result = produce();
                System.out.println("当前"+Thread.currentThread().getName()+" 生产者已生产数据："+result);
                System.out.println("数据即将放入队列中……");
                queue.put(result);
                System.out.println("数据已经放入队列中，等消费者消费!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    E produce() {

        try {
            Thread.sleep((long)(Math.random()*10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object o = new Random().nextInt();

        return (E) o;
    }

}
