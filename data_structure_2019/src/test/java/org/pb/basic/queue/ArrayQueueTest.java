package org.pb.basic.queue;

/**
 * @author boge.peng
 * @create 2019-06-04 23:50
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(4);

        queue.showQueue();

    }
}
