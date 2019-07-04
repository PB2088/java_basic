package org.pb.stack.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevApp {

    /**
     *<p>
     *description:
     *</p>
     *@param args
     * @author ex_pengbo
     * @throws IOException
     * @see
     */
    public static void main(String[] args) throws IOException {
        String inputStr;

        System.out.println("????????????????");
        inputStr = getInputStr();
        Reverser theRev = new Reverser(inputStr);
        System.out.println("????????");
        System.out.println(theRev.doRev());
    }

    public static String getInputStr() throws IOException {
        InputStreamReader is= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        return br.readLine();
    }
}
