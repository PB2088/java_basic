package org.pb.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer<E> implements Runnable {

    private final BlockingQueue<E> queue;

    public Consumer(BlockingQueue<E> q) {
        queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("当前"+Thread.currentThread().getName()+" 消费者正在等待消费数据……");
                try {
                    Thread.sleep((long)(Math.random()*10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                E result = queue.take();
                System.out.println("当前"+Thread.currentThread().getName()+" 消费者已消费数据："+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void consume(E obj) {
        System.out.println("消费数据："+obj);
    }

}
