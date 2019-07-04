package org.pb.jvm;

/**
 * @author boge.peng
 * @create 2019-04-07 22:42
 */
public class StackAllocation {
    public static void main(String[] args) {
        /**
         * -Xms200M -Xmx300M -XX:+PrintGCDetails
         */
        byte[] data = new byte[20 * 1024 * 1024];
    }
}
