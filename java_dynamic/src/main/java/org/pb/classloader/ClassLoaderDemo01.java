package org.pb.classloader;

/**
 * @author boge.peng
 * @create 2019-01-06 14:13
 */
public class ClassLoaderDemo01 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
