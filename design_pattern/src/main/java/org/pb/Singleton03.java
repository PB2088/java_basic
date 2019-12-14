package org.pb;

import java.util.Objects;

/**
 * 单例模式-懒汉式(线程不安全)
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton03 {

    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.getInstance();
        Singleton3 singleton2 = Singleton3.getInstance();

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() {}


    public static Singleton3 getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Singleton3();
        }

        return INSTANCE;
    }

}
