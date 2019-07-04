package org.pb.thread;

/**
 * @author boge.peng
 * @create 2019-03-30 22:40
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args) {

        Outputer outputer = new Outputer();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("pengbo");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("************");
            }
        }).start();
    }

    static class Outputer {
        private String lock="";
        public void output(String value) {
            synchronized (this) {
                for (char ch : value.toCharArray()) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
    }
}
