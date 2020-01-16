package org.pb.decorator.example;

/**
 * 摩卡调料
 * @author bo.peng
 * @create 2020-01-16 10:54
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",摩卡";
    }

    @Override
    public double cost() {
        return 10 + beverage.cost();
    }
}
