package org.pb.webserver.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author boge.peng
 * @create 2018-12-11 11:33
 */
public final class CommonUtils {
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            if (target != null) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
