package org.pb.basic.queue;

import java.util.Scanner;

/**
 * @author boge.peng
 * @create 2019-06-04 21:44
 */
public interface Queue<T> {
    /**
     * 入队
     * @param value
     */
    void enqueue(T value);

    /**
     * 出队
     * @return
     */
    T dequeue();

    /**
     * 队列是否已满
     * @return
     */
    boolean isFull();

    /**
     * 查看队列头元素
     * @return
     */
    T peekFront();

    /**
     * 队列是否空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列元素个数
     * @return
     */
    int size();

    /**
     * 打印队列
     */
    void printQueue();

    default void showQueue() {
        Scanner scanner = new Scanner(System.in);

        Queue queue = this;

        char key = ' ';
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("******************");
            System.out.println("****1-显示队列****");
            System.out.println("****2-增加数据到队列****");
            System.out.println("****3-从队列取出数据****");
            System.out.println("****4-查看队列头元素****");
            System.out.println("****5-退出程序****");
            System.out.println("******************");
            System.out.print("请选择操作:");

            key = scanner.next().charAt(0);

            switch (key) {
                case '1':
                    queue.printQueue();
                    break;
                case '2':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    try {
                        queue.enqueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '3':
                    try {
                        System.out.println(queue.dequeue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '4':
                    try {
                        System.out.println(queue.peekFront());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '5':
                    scanner.close();
                    isLoop = false;
                default:
                    break;
            }
        }

        System.out.println("退出程序!");
    }
}
