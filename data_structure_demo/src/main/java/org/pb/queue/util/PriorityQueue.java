package org.pb.queue.util;

public class PriorityQueue {
	/** 队列元素列表 */
	private long[] queueArray;
	/** 当前队列里存放的元素个数 */
	private int nItems;

	private int maxSize;

	public PriorityQueue(int s) {
		maxSize = s <= 0 ? 1 : s;
		queueArray = new long[maxSize];
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
	public void enqueue(long value) {
		//1.队列里面没有数据项的话,直接赋值
		if (nItems == 0) {
			queueArray[nItems++] = value;
		} else {
			//2.队列里面有数据项的话,则需要进行比较，排序
			int i = 0;
			for (i=nItems -1;i >= 0;i--) {
				if (value > queueArray[i]) {
					queueArray[i+1] = queueArray[i];
				} else {
					break;
				}
			}
			queueArray[i+1] = value;
			nItems++;
		}
		

	}

	/**
	 * 出队
	 * @return
	 */
	public long dequeue() {
		return queueArray[--nItems];
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
		return nItems+1;
	}
	
	/** 打印队列 */
	public void printQueue() {
		while (!isEmpty()) {
			System.out.print(dequeue()+"\t");
		}
		System.out.println();
	}
}
