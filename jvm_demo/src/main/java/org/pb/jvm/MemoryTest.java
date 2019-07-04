package org.pb.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author boge.peng
 * @create 2019-04-07 12:16
 */
public class MemoryTest {
    private List<User> users = new ArrayList<>();

    /**
     * -Xmx32M -Xms32M
     */
    public void heap() {
        int i=0;
        while (true) {
            users.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    public static void main(String[] args) {
        MemoryTest memory = new MemoryTest();
        memory.heap();
    }
}
