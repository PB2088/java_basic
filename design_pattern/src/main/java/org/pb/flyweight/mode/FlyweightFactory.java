package org.pb.flyweight.mode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bo.peng
 * @create 2020-03-11 17:15
 */
public class FlyweightFactory {
    private FlyweightFactory() {
    }

    private static class FlyweightFactoryInstance {
        public static final FlyweightFactory INSTANCE = new FlyweightFactory();
    }

    public static FlyweightFactory getInstance() {
        return FlyweightFactoryInstance.INSTANCE;
    }

    /** 缓存多个Flyweight对象 */
    private static final Map<String,Flyweight> fsMap = new HashMap<>();


    public Flyweight getFlyweight(String key) {
        if (fsMap.containsKey(key)) {
            return fsMap.get(key);
        }

        AuthorizationFlyweight authorizationFlyweight = new AuthorizationFlyweight(key);
        fsMap.put(key,authorizationFlyweight);

        return authorizationFlyweight;

    }
}
