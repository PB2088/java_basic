package org.pb.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author boge.peng
 * @create 2019-03-30 22:13
 */
public class TraditionalTimerTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!!!!!");
            }
        },2000,3000);

        while(true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
