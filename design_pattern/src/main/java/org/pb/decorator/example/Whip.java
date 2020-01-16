package org.pb.decorator.example;

/**
 * 奶泡调料
 * @author bo.peng
 * @create 2020-01-16 14:16
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +"," + "奶泡";
    }

    @Override
    public double cost() {
        return 3.5 + beverage.cost();
    }
}
