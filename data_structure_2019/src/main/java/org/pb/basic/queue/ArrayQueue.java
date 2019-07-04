package org.pb.basic.queue;

import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-06-04 22:01
 */
public class ArrayQueue<T> implements Queue<T> {

    /**
     * 队列元素列表
     */
    private T[] queueArray;
    /**
     * 头指针
     */
    private int front;
    /**
     * 尾指针
     */
    private int rear;
    /**
     * 当前队列里存放的元素个数
     */
    private int nItems;

    private int maxSize;

    private static final int DEFAULT_ITEMS = 16;

    public ArrayQueue(int size) {
        queueArray = (T[]) new Object[maxSize = size <= 0 ? DEFAULT_ITEMS : size];
        front = -1;
        rear = -1;
        nItems = 0;
    }

    @Override
    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法入队!!");
        }

        queueArray[++rear] = value;
        nItems++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法出队!!");
        }
        nItems--;
        return queueArray[++front];
    }

    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }

    @Override
    public T peekFront() {
        return queueArray[front+1];
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public int size() {
        return nItems;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据!");
            return;
        }

        for (int i = front + 1; i < queueArray.length; i++) {
            if (Objects.nonNull(queueArray[i])) {
                System.out.printf("Queue[%d]=%d\n", i, queueArray[i]);
            }
        }
    }
}
