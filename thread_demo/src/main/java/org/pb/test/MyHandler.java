package org.pb.test;

/**
 * @author boge.peng
 * @create 2019-09-02 21:25
 */
public class MyHandler implements Runnable {

    private HandlerService handlerService;

    private String method;

    private MyHandler(HandlerService handlerService, String method) {
        this.handlerService = handlerService;
        this.method = method;
    }

    public static MyHandler build(HandlerService handlerService, String method) {
        return new MyHandler(handlerService, method);
    }

    @Override
    public void run() {
        switch (method) {
            case "A":
                handlerService.methodA();
                break;
            case "B":
                handlerService.methodB();
                break;
            case "C":
                handlerService.methodC();
                break;
            case "D":
                handlerService.methodD();
                break;
            case "E":
                handlerService.methodE();
            default:
                break;
        }
    }
}
