package org.pb.basic.queue;

/**
 * @author boge.peng
 * @create 2019-06-04 23:50
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new CircleArrayQueue<>(5);

        queue.showQueue();

    }
}
