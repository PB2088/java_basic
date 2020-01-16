package org.pb.decorator.example;

/**
 * 浓缩咖啡
 * @author bo.peng
 * @create 2020-01-16 10:49
 */
public class Espresso extends Beverage {

    @Override
    public String getDescription() {
        return "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 19.0;
    }
}
