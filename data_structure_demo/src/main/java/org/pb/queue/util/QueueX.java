package org.pb.queue.util;

public class QueueX<T> {
	/** 队列元素列表 */
	private T[] queueArray;
	/** 头指针 */
	private int front;
	/** 尾指针 */
	private int rear;
	/** 当前队列里存放的元素个数 */
	private int nItems;

	private int maxSize;

	@SuppressWarnings("unchecked")
	public QueueX(int s) {
		maxSize = s <= 0 ? 1 : s;
		queueArray = (T[]) new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	/**
	 * 
	 * <p>
	 * description:入队
	 * </p>
	 * 
	 * @param value
	 * @author ex_pengbo
	 * @see
	 */
	public void enqueue(T value) {
		if (rear == maxSize-1) {
            rear = -1;
        }
		queueArray[++rear] = value;
		nItems++;
	}

	public T dequeue() {
		T value = queueArray[front++];
		if (front == maxSize) {
            front = 0;
        }
		nItems--;
		return value;
	}

	/**
	 * 
	 * <p>
	 * description:判断队列是否已满
	 * </p>
	 * 
	 * @return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isFull() {
		return nItems == maxSize;
	}
	
	/**
	 * 查看队头元素
	 * @return
	 */
	public T peekFront() {
		return queueArray[front];
	}

	/**
	 * 
	 * <p>
	 * description:判断队列是否是空
	 * </p>
	 * 
	 * @return
	 * @author ex_pengbo
	 * @see
	 */
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public int size() {
		return nItems;
	}
	
	/** 打印队列 */
	public void printQueue() {
		while (!isEmpty()) {
			System.out.print(dequeue()+"\t");
		}
		System.out.println("front:"+front);
		System.out.println();
	}
}
