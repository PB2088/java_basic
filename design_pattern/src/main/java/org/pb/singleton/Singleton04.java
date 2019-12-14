package org.pb.singleton;

import java.util.Objects;

/**
 * 单例模式-懒汉式(线程安全,同步方法)
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton04 {

    public static void main(String[] args) {
        System.out.println("单例模式-懒汉式(线程安全,同步方法)");
        Singleton4 singleton1 = Singleton4.getInstance();
        Singleton4 singleton2 = Singleton4.getInstance();

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {}


    public static synchronized Singleton4 getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Singleton4();
        }

        return INSTANCE;
    }

}
