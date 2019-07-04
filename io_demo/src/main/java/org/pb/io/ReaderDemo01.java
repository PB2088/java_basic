package org.pb.io;

import java.io.*;

/**
 * @author boge.peng
 * @create 2018-11-27 19:23
 */
public class ReaderDemo01 {
    public static void main(String[] args) {
        File src = new File("io_demo\\abc.txt");

        Reader reader = null;
        try {
            reader = new FileReader(src);

            int len;
            while ((len = reader.read()) != -1) {
                System.out.print((char) len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
