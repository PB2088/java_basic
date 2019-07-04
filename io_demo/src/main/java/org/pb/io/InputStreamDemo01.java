package org.pb.io;

import java.io.*;

/**
 * @author boge.peng
 * @create 2018-11-27 10:17
 */
public class InputStreamDemo01 {
    public static void main(String[] args) {
        InputStream is = null;

        try {
            is = new FileInputStream(new File("abc.txt"));

            int temp;

            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
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
