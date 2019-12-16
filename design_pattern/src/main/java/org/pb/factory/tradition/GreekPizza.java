package org.pb.factory.tradition;

/**
 * @author bo.peng
 * @create 2019-12-15 17:17
 */
public class GreekPizza extends Pizza {
    public GreekPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
