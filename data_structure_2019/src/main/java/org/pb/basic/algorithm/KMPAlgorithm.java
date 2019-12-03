package org.pb.basic.algorithm;

/**
 * KMP算法
 *
 * @author bo.peng
 * @create 2019-12-02 13:28
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str = "AAABBCCDDEEEEEEFFFFGGGGAAAAAAASDFSFSDFSSSS";
        String substr = "AASDF";

        int index = kmpMatch(str, substr);
        System.out.printf("索引位置%d", index);
    }

    /**
     * KMP匹配
     * @param str 主串
     * @param substr 模式串
     * @return
     */
    public static int kmpMatch(String str, String substr) {
        int[] next = getNextArray(str.toCharArray());

        for (int i = 0,j = 0; i < str.length(); i++) {

            while (j > 0 && str.charAt(i) != substr.charAt(j)) {
                j = next[j-1];
            }

            if (str.charAt(i) == substr.charAt(j)) {
                j++;
            }

            if (j == substr.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * 求出一个字符数组的next数组
     * @param chars 字符数组
     * @return next数组
     */
    private static int[] getNextArray(char[] chars) {
        int[] next = new int[chars.length];
        next[0] = 0;
        for (int i = 1,j = 0; i < chars.length; i++) {

            while (j > 0 && chars[i] != chars[j]) {
                j = next[j-1];
            }

            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
