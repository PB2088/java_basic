package org.pb.art;

import javafx.concurrent.Worker;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author boge.peng
 * @create 2019-05-07 0:19
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    /** 线程池最大线程数 */
    private static final int MAX_WORKER_NUMBERS = 10;

    /** 线程池默认线程数 */
    private static final int DEFAULT_WORKER_NUMBERS = 10;

    /** 线程池最小线程数 */
    private static final int MIN_WORKER_NUMBERS = 10;

    /** 工作列表,将会向里面插入工作 */
    private final LinkedList<Job> jobs = new LinkedList<>();

    /** 工作者列表 */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    /** 工作者线程的数量 */
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }


    @Override
    public void execute(Job job) {
        if (Objects.nonNull(job)) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        workers.stream().forEach(worker -> worker.shutdown());
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }

            initializeWorkers(num);
            this.workerNum = num;
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num > this.workerNum) {
                throw new IllegalArgumentException("Beyong workNum");
            }

            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                }
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    Job job = jobs.removeFirst();

                    if (Objects.nonNull(job)) {
                        try {
                            job.run();
                        } catch (Exception e) {
                            //e.printStackTrace();
                        }

                    }

                }
            }
        }

        public void shutdown() {
            running = false;
        }

    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);

            Thread thread = new Thread(worker,"ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }
}
