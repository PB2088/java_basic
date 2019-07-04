package org.pb.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableAndFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> future = threadPool.submit(() -> {
            Thread.sleep(2000);

            return "Hello";
        });

        System.out.println("等待结果……");
        System.out.println("拿到结果："+future.get(3,TimeUnit.SECONDS));
    }
}
