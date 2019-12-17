package org.pb.factory.factory.method.pizza;

/**
 *
 * 伦敦风味的奶酪披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:14
 */
public class LondonCheesePizza extends Pizza {

    public LondonCheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
