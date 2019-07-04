package org.pb.basic.linkedlist;

import java.util.Scanner;

/**
 * @author bo.peng
 * @create 2019-06-14 15:32
 */
public class JosephusTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总人数：");
        int total = scanner.nextInt();

        System.out.println("请输入报数的大小：");
        int stair = scanner.nextInt();

        System.out.println("请输入开始编号：");
        int start = scanner.nextInt();

        Josephus josephus = new Josephus(total,stair,start);
        System.out.println("开始报数出圈：");
        josephus.count();
    }
}
