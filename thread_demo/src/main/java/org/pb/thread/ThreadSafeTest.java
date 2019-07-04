package org.pb.thread;

import java.util.Objects;
import java.util.Random;

/**
 * @author boge.peng
 * @create 2019-03-30 20:41
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        Train12306 train12306 = new Train12306();
        new Thread(train12306, "窗口A").start();
        new Thread(train12306, "窗口B").start();
        new Thread(train12306, "窗口C").start();
    }
}


class Train12306 implements Runnable {

    private int tickets = 100;
    private Object lockObj;

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tickets > 0) {
                sell();
            }
        }
    }

    private void sell() {
        tickets--;
        System.out.println(Thread.currentThread().getName() + "抢到一张票,剩余票数:" + tickets);
    }
}
