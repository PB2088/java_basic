package org.pb.io;

import java.io.File;

/**
 * @author boge.peng
 * @create 2018-11-26 22:31
 */
public class FileDemo01 {
    public static void main(String[] args) {
        File src = new File("D:\\workspace-idea\\java_basic_demo\\20181126223307.jpg");

        System.out.println("名称："+src.getName());
        System.out.println("相对路径：" + src.getPath());
        System.out.println("绝对路径：" + src.getAbsolutePath());
        System.out.println("父路径：" + src.getParent());
        System.out.println("父对象：" + src.getParentFile().getName());

        System.out.println("----------------");
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否是文件：" + src.isFile());
        System.out.println("是否是目录：" + src.isDirectory());
        System.out.println("文件长度：" + src.length());


    }
}
