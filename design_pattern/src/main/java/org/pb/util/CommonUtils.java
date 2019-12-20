package org.pb.util;

import org.pb.prototype.deep.clone.DeepPrototype;

import java.io.*;
import java.util.Objects;

/**
 * @author bo.peng
 * @create 2019-12-20 10:47
 */
public final class CommonUtils {
    private CommonUtils() {
    }

    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                if (Objects.nonNull(target)) {
                    target.close();
                }
            } catch (IOException e) {

            }
        }
    }

    public static <T> T deepClone(T obj) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try  {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);

            ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(ois,oos,bos);
        }

        return null;
    }
}
