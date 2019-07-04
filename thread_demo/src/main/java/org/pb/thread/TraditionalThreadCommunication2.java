package org.pb.thread;

public class TraditionalThreadCommunication2 {

    public static void main(String[] args) {

        /**
         * 子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次
         * 接着再回到主线程又循环100次，如此循环50次，请写出程序。
         *
         *
         * **/
        final Business2 business = new Business2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }


    }
}

class Business2 {
    public synchronized void sub(int i) {
        for (int j = 1; j <= 10; j++) {
            System.out.println(Thread.currentThread().getName()+" sequece of " + j + ",loop of " + i);
        }
    }

    public synchronized void main(int i) {
        for (int j = 1; j <= 100; j++) {
            System.out.println(Thread.currentThread().getName() + " sequece of " + j + ",loop of " + i);
        }
    }
}
