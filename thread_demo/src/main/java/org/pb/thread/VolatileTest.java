package org.pb.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author boge.peng
 * @create 2019-03-28 23:02
 */
public class VolatileTest {

    private int count;

    public void addCount() {
        count ++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                volatileTest.addCount();
                System.out.println(volatileTest.getCount());
            }).start();
        }
    }
}
