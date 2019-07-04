package org.pb.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author boge.peng
 * @create 2018-11-27 20:43
 */
public class WriterDemo01 {
    public static void main(String[] args) {
        File dest = new File("io_demo" + File.separator + "dest_writer.txt");

        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            writer.write("啊哈哈,这种表在excel表里面怎么生成呀");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
