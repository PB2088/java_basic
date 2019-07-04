package org.pb.art;

import org.pb.util.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author boge.peng
 * @create 2019-04-01 0:07
 */
public class Deprecated {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");

        Thread printThread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " + format.format(new Date()));
                SleepUtils.second(1);
            }

        }, "PrintThread");

        printThread.setDaemon(true);
        printThread.start();
        SleepUtils.second(3);
        //将PrintThread进行暂停,输出内容工作停止
        printThread.suspend();
        System.out.println("main suspend PrintThread at " + format.format(new Date()));
        SleepUtils.second(3);
        //将PrintThread进行恢复,输出内容继续
        printThread.resume();
        System.out.println("main resume PrintThread at " + format.format(new Date()));
        SleepUtils.second(3);
        //将PrintThread进行终止,输出内容停止
        printThread.stop();
        System.out.println("main stop PrintThread at " + format.format(new Date()));
        SleepUtils.second(3);


    }
}
