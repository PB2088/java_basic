package org.pb.factory.factory.method.pizza;

/**
 *
 * 伦敦风味的胡椒披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:14
 */
public class LondonPepperoniPizza extends Pizza {

    public LondonPepperoniPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
