package org.pb.io;

import java.io.*;

/**
 * @author boge.peng
 * @create 2018-11-27 10:52
 */
public class OutputStreamDemo01 {
    public static void main(String[] args) {

        OutputStream os = null;
        try {
            File dest = new File("io_demo\\dest.txt");
            os = new FileOutputStream(dest,true);

            String context = "io is so easy!!!! ye ye ye !\r\n";

            os.write(context.getBytes());

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
        }


    }
}
