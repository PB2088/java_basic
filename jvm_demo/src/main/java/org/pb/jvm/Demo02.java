package org.pb.jvm;

/**
 * @author boge.peng
 * @create 2019-04-13 22:53
 */
public class Demo02 {
    public static int i = 1;

    static {
        i = 2;
    }

    public static void main(String[] args) {
        System.out.println(Sub.b);
    }

    static class Sub extends Demo02 {
        public static int b = i;
    }
}
