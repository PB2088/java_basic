package org.pb.factory.factory.method.pizza;

/**
 *
 * 北京风味的胡椒披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:14
 */
public class BeijingPepperoniPizza extends Pizza {

    public BeijingPepperoniPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
