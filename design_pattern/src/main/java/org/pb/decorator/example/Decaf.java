package org.pb.decorator.example;

/**
 * 低咖啡因
 * @author bo.peng
 * @create 2020-01-16 14:11
 */
public class Decaf extends Beverage {
    @Override
    public String getDescription() {
        return "低咖啡因";
    }

    @Override
    public double cost() {
        return 20.5;
    }
}
