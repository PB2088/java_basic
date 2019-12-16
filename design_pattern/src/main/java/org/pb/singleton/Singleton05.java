package org.pb.singleton;

import java.util.Objects;

/**
 * 单例模式-懒汉式(线程安全,双重检测锁)
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton05 {

    public static void main(String[] args) {
        System.out.println("单例模式-懒汉式(线程安全,双重检测锁)");
        Singleton5 singleton1 = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

class Singleton5 {
    private static volatile Singleton5 INSTANCE;

    private Singleton5() {}


    public static synchronized Singleton5 getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (Singleton5.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new Singleton5();
                }
            }
        }

        return INSTANCE;
    }

}
