package org.pb.jvm;

/**
 * 大对象直接进入老年代
 * @author boge.peng
 * @create 2019-04-07 22:42
 */
public class BigObjectIntoOldGen {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=6M  -XX:+PrintGCDetails
         */
        byte[] data4 = new byte[_1MB * 6];
    }
}
