package org.pb.basic.stack;

import java.util.Scanner;

/**
 * @author boge.peng
 * @create 2019-06-15 14:58
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        Stack<Integer> stack = new LinkedStack<>();
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("peek: 表示查看栈顶数据");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        Integer pop = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "peek":
                try {
                    Integer peek = stack.peek();
                    System.out.printf("栈顶元素是 %d\n", peek);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}
