package org.pb.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author boge.peng
 * @create 2019-03-30 22:40
 */
public class LockTest {
    public static void main(String[] args) {

        Outputer outputer = new Outputer();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("pengbo");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("************");
            }
        }).start();
    }

    static class Outputer {
        Lock lock = new ReentrantLock();

        public void output(String value) {
            lock.lock();
            try {

                for (char ch : value.toCharArray()) {
                    System.out.print(ch);
                }
                System.out.println();
            } finally {
                lock.unlock();
            }

        }
    }
}
