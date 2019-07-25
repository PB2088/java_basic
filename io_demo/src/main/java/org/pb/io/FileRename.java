package org.pb.io;

import java.io.*;
import java.util.Objects;

/**
 * 文件复制
 *
 * @author boge.peng
 * @create 2018-11-27 11:07
 */
public class FileRename {



    public static void rename(String srcDirPath) {
        File src = new File(srcDirPath);
        File[] files = src.listFiles();

        for (File file : files) {

            final boolean isContainsStr = file.getName().contains("【防断更微信：L21068888，公众号：zsxyfx】");
            File newFile = null;
            if (isContainsStr) {
                newFile = new File(file.getAbsolutePath().replace("【防断更微信：L21068888，公众号：zsxyfx】", ""));
                file.renameTo(newFile);
            }

            if (file.isDirectory()) {
                //System.out.println("----正在重命名"+file.getName()+"目录下的文件------");
                rename(Objects.nonNull(newFile) ? newFile.getAbsolutePath():file.getAbsolutePath());
            }


            /*if (file.isDirectory()) {
            System.out.println("----正在复制"+file.getName()+"目录下的文件------");
                File destDire = new File(destDirPath + File.separator + file.getName());

                rename(file.getAbsolutePath(), destDirPath + File.separator + file.getName());

            } else {
                System.out.println("--正在复制"+file.getName()+"");
                String newFilePath = destDirPath + File.separator + file.getName();
                //fileCopy(file.getAbsolutePath(), newFilePath);
            }*/

        }

    }

    public static void main(String[] args) {
        rename("H:\\投资理财课程");
    }
}
