package org.pb.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author boge.peng
 * @create 2019-09-02 21:24
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        HandlerService handlerService = new HandlerService();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(MyHandler.build(handlerService,"A"));
        executorService.execute(MyHandler.build(handlerService,"B"));
        executorService.execute(MyHandler.build(handlerService,"C"));
        executorService.execute(MyHandler.build(handlerService,"D"));
        executorService.execute(MyHandler.build(handlerService,"E"));

        executorService.shutdown();

        boolean isRunning = true;

        while (isRunning) {
            if (executorService.isTerminated()) {
                System.out.println("线程池所有任务都已经结束.");
                isRunning = false;
                break;
            }
        }
    }
}
