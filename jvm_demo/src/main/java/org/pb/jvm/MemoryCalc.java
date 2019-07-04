package org.pb.jvm;

/**
 * @author boge.peng
 * @create 2019-04-07 12:33
 */
public class MemoryCalc {
    public static void main(String[] args) {
        //返回Java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回Java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("MAX_MEMORY = " + maxMemory + "(字节)," + (maxMemory / 1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "(字节)," + (totalMemory / 1024 / 1024) + "MB");
    }
}
