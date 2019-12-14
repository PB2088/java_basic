package org.pb;

/**
 * 单例模式-饿汉式(静态代码块)
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton02 {

    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

class Singleton2 {
    private static Singleton2 INSTANCE;

    private Singleton2() {}

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

}
