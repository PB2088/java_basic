package org.pb.decorator.example;

/**
 * 饮料抽象类
 * @author bo.peng
 * @create 2020-01-13 16:00
 */
public abstract class Beverage {

    /**
     * 获取调料描述信息,由子类实现
     * @return
     */
    public abstract String getDescription();

    /**
     * 计算成本
     * @return
     */
    public abstract double cost();
}
