package org.pb;

/**
 * 单例模式-懒汉式(线程安全,静态内部类)
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton06 {

    public static void main(String[] args) {
        System.out.println("单例模式-懒汉式(线程安全,静态内部类)");
        Singleton6 singleton1 = Singleton6.getInstance();
        Singleton6 singleton2 = Singleton6.getInstance();

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

class Singleton6 {

    private Singleton6() {}

    public static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
