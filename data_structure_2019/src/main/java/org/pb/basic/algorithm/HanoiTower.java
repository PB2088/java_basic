package org.pb.basic.algorithm;

/**
 * 什么是分治算法？就是将一个难以解决的大问题，分割成一些规模较小并且相对独立的相同问题，以便各个击破，分而治之
 * 汉诺塔问题是一个十分经典的可以通过分治算法解决的问题，存在A、B、C大小形同的3根石柱，
 * 其中A石柱从下往上按照大小顺序依次摆放着n个盘子，现在需要将A石柱的盘子全部移动到C石柱上，并且每次只能移动一个圆盘，小圆盘不能放在大圆盘上，
 * 请问该如何移动？
 *
 * @author bo.peng
 * @create 2019-11-20 14:17
 */
public class HanoiTower {
    public static int num = 1;

    public static void main(String[] args) {
        solve(3);
    }

    private static void solve(int n) {
        /** 已知条件n个圆盘和A、B、C三根石柱 */
        hanoi(n,"A","B","C");
    }

    /**
     * 若要让第n个圆盘成功从A移动到C，需要让前n-1个圆盘先从A移动到B，然后让第n个圆盘从A移动到C，
     * 最后让第n-1个圆盘从B移动到C，至于如何将前n-1个圆盘从A移动到B或者从A移动到C，仅仅是和父问
     * 题相同的子问题，采用父问题的解决方案即可。
     */
    private static void hanoi(int n,String a,String b,String c) {
        if (n == 1) {
            move(n,a,c);
        } else {
            /** 将前n-1个圆盘从石柱A移动到石柱B */
            hanoi(n -1,a,c,b);

            /** 将第n号圆盘从石柱A移动到石柱C */
            move(n,a,c);

            /** 将前n-1个圆盘从石柱B移动到石柱C */
            hanoi(n -1,b,a,c);

        }
    }

    private static void move(int n, String a, String c) {
        System.out.printf("%d: 第%d个圆盘,从%s移动到%s\n",num++,n,a,c);
    }
}
