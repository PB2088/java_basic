package org.pb.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author boge.peng
 * @create 2019-03-31 20:42
 */
public class ThreadPoolExecutorTest {

    @Test
    public void testCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            int temp = i;
            cachedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "----" +temp);
            });
        }
    }

    @Test
    public void testFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 1 ;i <= 10;i++) {
            int temp = i;
            fixedThreadPool.execute(() ->{
                System.out.println(Thread.currentThread().getName() + "----" +temp);
            });
        }
    }

    @Test
    public void testScheduledThreadPool() {
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 1 ;i <= 10;i++) {
            int temp = i;
            scheduledThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "----" +temp);
            });
        }
    }

    @Test
    public void testSingleThreadPool() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 1 ;i <= 10;i++) {
            int temp = i;
            singleThreadExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "----" +temp);
            });
        }
    }
}
