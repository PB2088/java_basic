package org.pb.classloader;

import java.io.*;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-01-06 14:39
 */
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(className);

        if (Objects.equals(c, null)) {
            try {
                c = this.getParent().loadClass(className);
            } catch (Exception e) {
            }

            if (Objects.equals(c, null)) {
                byte[] datas = getClassData(className);
                if (datas == null) {
                    throw new ClassNotFoundException();
                }
                c = defineClass(className, datas, 0, datas.length);
            }
        }
        return c;
    }

    private byte[] getClassData(String className) {
        String path = rootDir + "/" + className.replace(".", "/") + ".class";
        try (InputStream is = new FileInputStream(path);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();) {

            byte[] buffer = new byte[1];

            int temp;
            while ((temp = is.read(buffer)) != -1) {
                bos.write(buffer);
            }

            return bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
