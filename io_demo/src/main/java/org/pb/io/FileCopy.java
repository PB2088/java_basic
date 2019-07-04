package org.pb.io;

import java.io.*;

/**
 * 文件复制
 *
 * @author boge.peng
 * @create 2018-11-27 11:07
 */
public class FileCopy {

    public static void fileCopy(String srcPath, String destPath) {

        OutputStream os = null;
        InputStream is = null;

        try {
            File src = new File(srcPath);
            File dest = new File(destPath);

            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int len;

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void directoryCopy(String srcDirPath, String destDirPath) {
        File src = new File(srcDirPath);
        File[] files = src.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("----正在复制"+file.getName()+"目录下的文件------");
                File destDire = new File(destDirPath + File.separator + file.getName());

                destDire.mkdirs();

                directoryCopy(file.getAbsolutePath(), destDirPath + File.separator + file.getName());

            } else {
                System.out.println("--正在复制"+file.getName()+"");
                String newFilePath = destDirPath + File.separator + file.getName();
                fileCopy(file.getAbsolutePath(), newFilePath);
            }

        }

    }

    public static void main(String[] args) {
        /*FileCopy.copy("io_demo\\dest.txt","destCopy.txt");*/
        directoryCopy("D:\\hibernate-4.3.6", "D:\\hibernate-4.3.6_copy");
    }
}
