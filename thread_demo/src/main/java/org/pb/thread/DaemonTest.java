package org.pb.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-03-30 0:07
 */
public class DaemonTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("子线程---" + i);
            }
        }, "子线程执行");

        t1.setDaemon(true);
        t1.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程---" + i);
        }
        System.out.println("主线程执行结束......");
    }
}
