package org.pb.jvm.test05;

/**
 * @author boge.peng
 * @create 2019-04-08 13:17
 */
public class TryFinally {
    public static void main(String[] args) {
        System.out.println(f1());
    }

    public static String f1() {
        String str = "Hello";

        try {
            return str;
        } finally {
            str = "World";
        }
    }
}
