package org.pb.basic.queue;

/**
 * 环形队列
 *
 * @author boge.peng
 * @create 2019-06-07 23:12
 */
public class CircleArrayQueue<T> implements Queue<T> {
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

    private int maxSize;

    private static final int DEFAULT_ITEMS = 16;

    public CircleArrayQueue(int size) {
        queueArray = (T[]) new Object[maxSize = size <= 0 ? DEFAULT_ITEMS : size];
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法入队!!");
        }

        queueArray[rear] = value;
        rear = (rear + 1) % maxSize;

    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法出队!!");
        }

        T value = queueArray[front];
        front = (front + 1) % maxSize;

        return value;
    }

    @Override
    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    @Override
    public T peekFront() {
        return queueArray[front];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据!");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, queueArray[i % maxSize]);
        }
    }
}
