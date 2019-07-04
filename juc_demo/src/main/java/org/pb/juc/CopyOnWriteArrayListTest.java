package org.pb.juc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author boge.peng
 * @create 2018-12-04 9:59
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteThread thread = new CopyOnWriteThread();

        for (int i = 0; i < 10; i++) {
            new Thread(thread).start();
        }
    }
}

class CopyOnWriteThread implements Runnable {
    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static List<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            list.add("啊哈哈");
        }
    }
}
