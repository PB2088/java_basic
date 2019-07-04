package org.pb.jvm;

/**
 * @author boge.peng
 * @create 2019-04-07 22:42
 */
public class EdenAllocator2 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8  -XX:+PrintGCDetails
         */
        byte[] data1 = new byte[_1MB * 2];
        byte[] data2 = new byte[_1MB * 2];
        byte[] data3 = new byte[_1MB * 2];
        byte[] data4 = new byte[_1MB * 6];
    }
}
