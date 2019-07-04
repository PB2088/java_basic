package org.pb.thread;

/**
 * @author boge.peng
 * @create 2019-03-30 17:46
 */
public class ThreadJoinTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        }, "线程1");

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        }, "线程2");

        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        }, "线程3");
        t3.start();

    }
}
