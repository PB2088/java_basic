package org.pb.util;

import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-04-01 0:11
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
