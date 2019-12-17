package org.pb.factory.simple.factory.pizza;

/**
 *
 * 蛤蜊披萨
 *
 * @author bo.peng
 * @create 2019-12-15 17:14
 */
public class ClamPizza extends Pizza {

    public ClamPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.printf("开始准备%s的原材料\n", getName());
    }
}
