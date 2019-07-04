package org.pb.juc;

import org.pb.juc.util.CopyOnWriteMap;

import java.util.Iterator;
import java.util.Map;

/**
 * @author boge.peng
 * @create 2018-12-04 10:33
 */
public class CopyOnWriteMapTest {
    public static void main(String[] args) {
        CopyOnWriteMapThread thread = new CopyOnWriteMapThread();

        for (int i = 0; i < 10; i++) {
            new Thread(thread).start();
        }
    }
}

class CopyOnWriteMapThread implements Runnable {
    //private static Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
    private static Map<String,String> map = new CopyOnWriteMap<>();

    static {
        map.put("AA","AA");
        map.put("BB","BB");
        map.put("CC","CC");
        map.put("DD","DD");
    }

    @Override
    public void run() {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key:"+key + "----" + map.get(key));

            map.put("哈哈","哈哈");
        }
    }
}
