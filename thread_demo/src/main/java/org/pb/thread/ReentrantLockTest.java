package org.pb.thread;

import org.pb.util.SleepUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author boge.peng
 * @create 2019-04-04 22:43
 */
public class ReentrantLockTest implements Runnable {
    public static void main(String[] args) {
        ReentrantLockTest reentrantLock = new ReentrantLockTest();
        new Thread(reentrantLock).start();
        new Thread(reentrantLock).start();
        new Thread(reentrantLock).start();
        new Thread(reentrantLock).start();
    }

    private Lock lock = new ReentrantLock();

    public void test01() {
        lock.lock();
        try {
            SleepUtils.second(1);
            System.out.println("test01()===" + Thread.currentThread().getName());
            test02();
        } finally {
            lock.unlock();
        }

    }

    private void test02() {
        lock.lock();
        try {
            SleepUtils.second(1);
            System.out.println("test02()===" + Thread.currentThread().getName());

            test03();
        } finally {
            //SleepUtils.second(5);
            //lock.unlock();
        }
    }

    private void test03() {
        lock.lock();
        try {
            SleepUtils.second(1);
            System.out.println("test03()===" + Thread.currentThread().getName());
        } finally {
            //SleepUtils.second(5);
            lock.unlock();
        }
    }

    @Override
    public void run() {
        test01();
    }
}
