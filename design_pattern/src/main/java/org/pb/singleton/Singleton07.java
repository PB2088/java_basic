package org.pb.singleton;

/**
 * 单例模式-枚举
 *
 * @author bo.peng
 * @create 2019-12-14 22:26
 */
public class Singleton07 {

    public static void main(String[] args) {
        System.out.println("单例模式-枚举");
        Singleton7 singleton1 = Singleton7.INSTANCE;
        Singleton7 singleton2 = Singleton7.INSTANCE;

        System.out.println("singleton1.hashCode() = " + singleton1.hashCode());
        System.out.println("singleton2.hashCode() = " + singleton2.hashCode());
    }

}

/**
 * 枚举类实现单例模式
 */
enum  Singleton7 {

    INSTANCE;

    public void method001() {
        System.out.println("ok~");
    }

}
