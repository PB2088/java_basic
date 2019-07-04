package org.pb.art;

import org.pb.util.SleepUtils;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author boge.peng
 * @create 2019-05-04 18:31
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final long begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
        return TIME_THREADLOCAL.get();
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        System.out.println("begin time: " + Profiler.begin());
        SleepUtils.second(10);
        System.out.println("Cost: " + Profiler.end() + " mills");

        System.out.println("-----------------");

        Thread thread001 = new Thread(() -> {
            Profiler.begin();

            SleepUtils.second(10);

            System.out.println(Thread.currentThread().getName() + " run cost: " + Profiler.end() + " mills");

        },"Thread-001");

        Thread thread002 = new Thread(() -> {

            try {
                thread001.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Profiler.begin();

            SleepUtils.second(3);

            System.out.println(Thread.currentThread().getName() + " run cost: " + Profiler.end() + " mills");

        },"Thread-002");

        thread002.start();
        thread001.start();

    }
}
