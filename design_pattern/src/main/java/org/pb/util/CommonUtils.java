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

    public static String jsonParse(String jsonStr) {
        char[] myBuffer = jsonStr.toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(myBuffer[i]);
            // 判断是否是中日韩文字
            if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                char c = jsonStr.charAt(i);
                sb.append("\\u");
                //取出高8位
                int j = (c >>>8);
                String tmp = Integer.toHexString(j);
                if (tmp.length() == 1) {
                    sb.append("0");
                }
                sb.append(tmp);
                //取出低8位
                j = (c & 0xFF);
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1)
                    sb.append("0");
                sb.append(tmp);
            } else {
                sb.append(myBuffer[i]);
            }
        }

        return sb.toString();
    }
}
