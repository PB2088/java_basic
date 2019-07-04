package org.pb.classloader;

/**
 * @author boge.peng
 * @create 2019-01-06 15:29
 */
public class FileSystemClassLoaderTest {
    public static void main(String[] args) {
        FileSystemClassLoader loader = new FileSystemClassLoader("D:/myjava");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("D:/myjava");

        try {
            Class<?> c = loader.loadClass("org.pb.classloader.User");
            Class<?> c1 = loader.loadClass("org.pb.classloader.User");
            Class<?> c2 = loader2.loadClass("org.pb.classloader.User");
            System.out.println(c.hashCode());
            System.out.println(c1.hashCode());
            System.out.println(c2.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
