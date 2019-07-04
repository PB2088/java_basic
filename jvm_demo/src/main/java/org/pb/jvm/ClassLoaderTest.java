package org.pb.jvm;

/**
 * @author boge.peng
 * @create 2019-04-07 9:58
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}
