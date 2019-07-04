package org.pb.jvm;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-04-14 13:47
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private volatile boolean isRunning = true;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("启动消费者线程!");

        try {
            while (isRunning) {
                System.out.println("正从队列获取数据....");
                String data = queue.poll(2,TimeUnit.SECONDS);
                if (!Objects.equals(data,null)) {
                    System.out.println("拿到数据: " + data);
                    System.out.println("正在消费数据: " + data);
                    //Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                } else {
                    stop();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出消费者线程!");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
