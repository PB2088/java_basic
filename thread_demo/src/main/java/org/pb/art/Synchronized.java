package org.pb.art;

/**
 * @author boge.peng
 * @create 2019-04-01 0:32
 */
public class Synchronized {
    public static void main(String[] args) {
        //对Synchronized Class 对象进行加锁
        synchronized (Synchronized.class) {

        }

        //静态同步访求,对Synchronized Class对象进行加锁
        m();
    }

    private static synchronized void m() {

    }
}
