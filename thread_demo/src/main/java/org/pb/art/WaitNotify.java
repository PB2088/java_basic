package org.pb.art;

import org.pb.util.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-05-04 15:42
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
       Thread waitThread = new Thread(() -> {
           //加锁,拥有lock的Monitor
            synchronized (lock) {
                //当条件不满足时,继续wait,同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait " +
                                "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }

                //条件满足时,完成工作
                System.out.println(Thread.currentThread() + " flag is false. runing " +
                        "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        },"WaitThread");
       waitThread.start();

       SleepUtils.second(1);

       Thread notifyThread = new Thread(() -> {
           //加锁,拥有lock的Monitor
           synchronized (lock) {
               System.out.println(Thread.currentThread() + " hold lock. notify " +
                       "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
               lock.notifyAll();
               flag = false;
               SleepUtils.second(5);
           }

           synchronized (lock) {
               System.out.println(Thread.currentThread() + " hold lock again. sleep " +
                       "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
               SleepUtils.second(5);
           }
       },"NotifyThread");
        notifyThread.start();
    }

}
