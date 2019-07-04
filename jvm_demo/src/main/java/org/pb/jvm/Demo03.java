package org.pb.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-04-13 23:02
 */
public class Demo03 {
    static class Hello {
        static {
            System.out.println(Thread.currentThread().getName() + " init......");

            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start......");
            new Hello();
            System.out.println(Thread.currentThread().getName() + " end......");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start......");
            new Hello();
            System.out.println(Thread.currentThread().getName() + " end......");
        }).start();
    }
}
