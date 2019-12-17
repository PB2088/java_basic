package org.pb.factory.factory.method.pizza;

/**
 * 北京风味的希腊披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:17
 */
public class BeijingGreekPizza extends Pizza {
    public BeijingGreekPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
