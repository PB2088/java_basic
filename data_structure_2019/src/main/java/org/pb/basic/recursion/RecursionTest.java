package org.pb.basic.recursion;

/**
 * @author boge.peng
 * @create 2019-06-20 22:03
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } else {
            System.out.println("n=" + n);
        }

    }
}
