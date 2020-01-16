package org.pb.decorator.example;

/**
 * 豆浆调料
 * @author bo.peng
 * @create 2020-01-16 14:13
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "," + "豆浆";
    }

    @Override
    public double cost() {
        return 2.0 + beverage.cost();
    }
}
