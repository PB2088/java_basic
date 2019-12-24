package org.pb.adapter.example;

/**
 * 适配器
 * @author bo.peng
 * @create 2019-12-24 15:42
 */
public class Adapter implements Target {

    /** 持有需要被适配的对象 */
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
