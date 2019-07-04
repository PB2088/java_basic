package org.pb.thread;

/**
 * @author boge.peng
 * @create 2019-03-30 21:46
 */
public class TraditionalThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable run:" + Thread.currentThread().getName() + " running....");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread run:" + Thread.currentThread().getName() + " running....");
            }
        }.start();

        new Thread(() -> {
            System.out.println("Runnable run:" + Thread.currentThread().getName() + " running....");
        }) {
            @Override
            public void run() {
                System.out.println("Thread run:" + Thread.currentThread().getName() + " running....");
            }
        }.start();
    }
}
