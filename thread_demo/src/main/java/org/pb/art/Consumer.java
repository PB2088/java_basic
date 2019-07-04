package org.pb.art;

import java.util.concurrent.BlockingQueue;

/**
 * @author boge.peng
 * @create 2019-04-02 22:46
 */
public class Consumer<E> implements Runnable {
    private BlockingQueue<E> queue;

    public Consumer(BlockingQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("当前"+Thread.currentThread().getName()+" 消费者正在等待消费数据....");
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
}
