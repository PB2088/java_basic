package org.pb.adapter.example;

/**
 * @author bo.peng
 * @create 2019-12-24 15:43
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());

        target.request();
    }
}
