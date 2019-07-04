package org.pb.io;

import java.io.File;

/**
 * @author boge.peng
 * @create 2018-11-26 23:56
 */
public class DirectoryCounter {
    private String path;

    private long size;

    private int fileCount;

    private int dirCount;

    public int getFileCount() {
        return fileCount;
    }

    public int getDirCount() {
        return dirCount -1;
    }

    private DirectoryCounter(String path) {
        this.path = path;
    }

    public static DirectoryCounter newInstance(String path) {
        return new DirectoryCounter(path);
    }

    public void count() {
        count(new File(path));
    }

    private void count(File src) {
        if (src != null && src.exists()) {
            if (src.isFile()) {
                size += src.length();

                this.fileCount ++;
            } else {
                this.dirCount++;

                for (File file : src.listFiles()) {
                    count(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        DirectoryCounter directoryCounter = DirectoryCounter.newInstance("D:\\hibernate-4.3.6");
        directoryCounter.count();

        System.out.println("大小："+directoryCounter.getSize());

        System.out.println("包含：" + directoryCounter.getFileCount() + "个文件," + directoryCounter.getDirCount() + "个文件夹");

    }

    public long getSize() {
        return size;
    }
}
