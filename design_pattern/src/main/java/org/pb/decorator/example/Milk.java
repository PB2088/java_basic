package org.pb.decorator.example;

/**
 * 牛奶调料
 * @author bo.peng
 * @create 2020-01-16 14:17
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "," + "牛奶";
    }

    @Override
    public double cost() {
        return 5.0 + beverage.cost();
    }
}
