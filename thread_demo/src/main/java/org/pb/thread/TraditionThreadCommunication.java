package org.pb.thread;

/**
 * @author boge.peng
 * @create 2019-03-31 9:03
 */
public class TraditionThreadCommunication {
    /**
     * 主线程循环100次，接着子线程循环10次，接着又回到主线程循环100次
     * 接着再回到子线程循环10次，如此循环50次，请写出程序。
     **/
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                business.sub(i);
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

}

class Business {
    private boolean bShouldSub = true;

    public synchronized void sub(int i) {
        while (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequence of " + j + ",loop of " + i);
        }
        bShouldSub = false;
        this.notify();
    }

    public synchronized void main(int i) {
        while (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequence of " + j + ",loop of " + i);
        }
        bShouldSub = true;
        this.notify();
    }
}
