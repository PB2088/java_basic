package org.pb.io;

import java.io.*;

/**
 * @author boge.peng
 * @create 2018-11-27 10:17
 */
public class InputStreamDemo02 {
    public static void main(String[] args) {
        InputStream is = null;

        try {

            is = new FileInputStream(new File("io_demo\\abc.txt"));

            byte[] buffer = new byte[1024*10];

            int len;
            while ((len = is.read(buffer)) != -1) {
                String str = new String(buffer);
                System.out.println(len+"--------->"+str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
