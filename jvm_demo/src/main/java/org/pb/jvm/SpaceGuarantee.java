package org.pb.jvm;

/**
 * 空间分配担保
 * @author boge.peng
 * @create 2019-04-07 23:16
 */
public class SpaceGuarantee {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        /** VM参数：
         -verbose：gc
         -Xms20M
         -Xmx20M
         -Xmn10M
         -XX:+PrintGCDetails
         -XX:SurvivorRatio=8
         */
        byte[] data1 = new byte[_1MB * 2];
        byte[] data2 = new byte[_1MB * 2];
        byte[] data3 = new byte[_1MB * 2];
        byte[] data4 = new byte[_1MB * 4];

        System.gc();
    }
}
