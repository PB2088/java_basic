package org.pb.factory.factory.method.pizza;

/**
 *
 * 伦敦风味的蛤蜊披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:14
 */
public class LondonClamPizza extends Pizza {

    public LondonClamPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
