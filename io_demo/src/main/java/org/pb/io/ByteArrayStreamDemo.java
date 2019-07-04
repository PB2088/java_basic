package org.pb.io;

import java.io.*;

/**
 * @author boge.peng
 * @create 2018-11-27 20:47
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {

        byteArrayToFile(fileToByteArray("20181126223307.jpg"),"io_demo\\20181126223307_byteArray.jpg");

    }

    public static byte[] fileToByteArray(String filePath) {
        byte[] buffer = new byte[1024 * 10];
        ByteArrayOutputStream bos = null;
        try(InputStream is = new FileInputStream(new File(filePath));) {

            bos = new ByteArrayOutputStream();

            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer);
            }

            bos.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bos.toByteArray();
    }

    public static void byteArrayToFile(byte[] src,String destPath) {
        File dest = new File(destPath);

        OutputStream os = null;

        try {

            os = new FileOutputStream(dest);

            ByteArrayInputStream bis = new ByteArrayInputStream(src);

            byte[] buffer = new byte[1024*10];

            int len;
            while ((len = bis.read(buffer)) != -1) {
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
        }
    }

}
