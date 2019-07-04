package org.pb.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author boge.peng
 * @create 2019-05-11 18:36
 */
public final class CommonUtils {
    public static void release(Closeable... closeables) {
        if (closeables != null) {
            Arrays.stream(closeables).forEach(closeable -> {
                try {
                    closeable.close();
                } catch (IOException e) {

                }
            });
        }
    }
}
