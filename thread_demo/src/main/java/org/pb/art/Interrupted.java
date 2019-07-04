package org.pb.art;

import org.pb.util.SleepUtils;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-05-04 15:13
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(() -> {
            while (true) {
                SleepUtils.second(10);
            }
        },"SleepThread");

        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(() -> {
            while (true) {

            }
        },"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        SleepUtils.second(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }
}
