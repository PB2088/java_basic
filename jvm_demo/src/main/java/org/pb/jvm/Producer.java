package org.pb.jvm;

import java.net.StandardProtocolFamily;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author boge.peng
 * @create 2019-04-14 13:47
 */
public class Producer implements Runnable {

    private BlockingQueue<String> queue;
    private volatile boolean isRunning = true;
    private static AtomicInteger count = new AtomicInteger();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String data = null;
        Random random = new Random();
        System.out.println("启动生产者线程!");

        try {
            while (isRunning) {
                System.out.println("正在生产数据....");
                TimeUnit.MILLISECONDS.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                data = "data:" + new byte[1024 * 1024] + ":" + count.incrementAndGet();
                System.out.println("将数据: " + data + " 放入队列....");
                if (!queue.offer(data,2,TimeUnit.SECONDS)) {
                    System.out.println("放入数据失败:" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出生产者线程!");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
