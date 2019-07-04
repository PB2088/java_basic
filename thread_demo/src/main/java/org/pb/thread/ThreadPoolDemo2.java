package org.pb.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {
    public static void main(String[] args) throws Exception {

        System.out.println(Thread.currentThread().getName()+"主线程执行开始");

        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程执行开始");

                for (int j = 1; j <= 20; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " is looping of  " + j
                            + " for task of " + j);
                }

                System.out.println(Thread.currentThread().getName()+"线程执行结束");
            }
        });

        threadPool.shutdown();

        System.out.println(Thread.currentThread().getName()+"主线程执行中……");

        for (int j = 1; j <= 10; j++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is looping of  " + j
                    + " for task of " + j);
        }

        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName()+"主线程执行完毕!");
    }
}
