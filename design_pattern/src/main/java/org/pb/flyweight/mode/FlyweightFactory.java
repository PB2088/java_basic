package org.pb.flyweight.mode;

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



}
