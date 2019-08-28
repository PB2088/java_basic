package org.pb.util;

/**
 * @author bo.peng
 * @create 2019-08-13 10:27
 */
public class Test {
    public static void main(String[] args) {

        StringBuilder sqlBuf = new StringBuilder();
        sqlBuf.append("(?,");
        System.out.println(sqlBuf);

        sqlBuf.replace(sqlBuf.length() -1, sqlBuf.length(), ")");

        System.out.println(sqlBuf);
    }
}
