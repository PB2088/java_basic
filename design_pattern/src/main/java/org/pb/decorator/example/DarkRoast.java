package org.pb.decorator.example;

/**
 * 深烘焙咖啡
 * @author bo.peng
 * @create 2020-01-16 14:09
 */
public class DarkRoast extends Beverage {
    @Override
    public String getDescription() {
        return "深烘焙咖啡";
    }

    @Override
    public double cost() {
        return 19.8;
    }
}
