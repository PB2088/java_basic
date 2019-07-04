package org.pb.io;

import java.io.*;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-11-28 11:07
 */
public class ConvertStreamDemo {
    public static void main(String[] args) {
        String msg = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            while (!Objects.equals("exit", msg)) {
                msg = reader.readLine();

                writer.write(msg);

                writer.newLine();

                writer.flush();
            }
        } catch (IOException e) {

        }

    }
}
