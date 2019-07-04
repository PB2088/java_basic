package org.pb.jvm.test05;

/**
 * @author boge.peng
 * @create 2019-03-26 10:58
 */
public class StringAdd {
    public static void main(String[] args) {

    }

    public static void f1() {
        String aa = "";
        for (int i=0;i<100;i++) {
            aa += i;
        }

        System.out.println(aa);
    }

    public static void f2() {
        StringBuilder aa = new StringBuilder();
        for (int i=0;i<100;i++) {
            aa.append(i);
        }

        System.out.println(aa.toString());
    }
}
