package org.pb.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boge.peng
 * @create 2019-04-07 12:48
 */
public class JVMTest01 {
    byte[] byteArray = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<JVMTest01> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new JVMTest01());
                count++;
            }
        } catch (Throwable e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
