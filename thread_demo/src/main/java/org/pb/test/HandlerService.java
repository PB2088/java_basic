package org.pb.test;

import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-09-02 21:25
 */
public class HandlerService {
    public void methodA() {
        System.out.println("methodA start running...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodA stop running.");
    }

    public void methodB() {
        System.out.println("methodB start running...");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodB stop running.");
    }

    public void methodC() {
        System.out.println("methodC start running...");

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodC stop running.");
    }

    public void methodD() {
        System.out.println("methodD start running...");

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodD stop running.");
    }

    public void methodE() {
        System.out.println("methodE start running...");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodE stop running.");
    }
}
