package org.pb.decorator.example;

/**
 * 综合咖啡
 * @author bo.peng
 * @create 2020-01-16 14:02
 */
public class HouseBlend extends Beverage {
    @Override
    public String getDescription() {
        return "综合咖啡";
    }

    @Override
    public double cost() {
        return 8.9;
    }
}
