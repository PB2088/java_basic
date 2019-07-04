package org.pb.art;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author boge.peng
 * @create 2019-04-02 22:39
 */
public class Producer<E> implements Runnable {
    private final BlockingQueue<E> queue;

    public Producer(BlockingQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("当前" + Thread.currentThread().getName() + "生产者正在生产数据......");
            E result = produce();
            System.out.println("当前"+Thread.currentThread().getName()+" 生产者已生产数据："+result);
            System.out.println("数据即将放入队列中......");
            try {
                queue.put(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数据已经放入队列中，等消费者消费!");
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
