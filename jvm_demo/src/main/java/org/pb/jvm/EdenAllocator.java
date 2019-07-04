package org.pb.jvm;

/**
 * 逃逸分析与栈上分配
 * @author boge.peng
 * @create 2019-04-07 22:42
 */
public class EdenAllocator {
    public static void main(String[] args) {
        /**
         * -Xms200M -Xmx300M -XX:+PrintGCDetails
         */
        byte[] data = new byte[20 * 1024 * 1024];
    }
}
