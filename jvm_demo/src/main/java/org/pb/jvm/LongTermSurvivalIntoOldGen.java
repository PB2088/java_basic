package org.pb.jvm;

/**
 * 长期存活的对象进入老年代
 * @author boge.peng
 * @create 2019-04-07 23:16
 */
public class LongTermSurvivalIntoOldGen {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        /** VM参数：
         -verbose：gc
         -Xms20M
         -Xmx20M
         -Xmn10M
         -XX:+PrintGCDetails
         -XX:SurvivorRatio=8
         -XX:MaxTenuringThreshold=1
         -XX:+PrintTenuringDistribution
         -XX:+UseSerialGC
         */
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];  // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
