package org.pb.basic.algorithm;

/**
 * 暴力匹配算法
 * @author bo.peng
 * @create 2019-11-30 15:55
 */
public class BruteForceMatch {

    public static void main(String[] args) {
        String str = "AAABBCCDDEEEEEEFFFFGGGGAAAAAAASDFSFSDFSSSS";
        String substr = "AASDFZ";

        int index = search(str, substr);
        System.out.printf("索引位置%d", index);
    }

    /**
     * 暴力匹配查找
     * @param str
     * @param substr
     * @return
     */
    public static int search(String str,String substr) {
        char[] strCharArray = str.toCharArray();
        char[] substrCharArray = substr.toCharArray();

        /* 指向strCharArray */
        int strIndex = 0;
        /* 指向substrCharArray */
        int substrIndex = 0;

        while (strIndex < strCharArray.length && substrIndex < substrCharArray.length) {
            if (strCharArray[strIndex] == substrCharArray[substrIndex]) {
                strIndex++;
                substrIndex++;
            } else {
                strIndex = strIndex - (substrIndex -1);
                substrIndex = 0;
            }
        }

        if (substrIndex == substrCharArray.length) {
            return strIndex - substrIndex;
        }

        return -1;
    }
}
