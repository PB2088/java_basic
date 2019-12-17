package org.pb.factory.simple.factory.factory;

import org.pb.factory.simple.factory.pizza.*;

/**
 * 简单工厂模式
 *
 * @author bo.peng
 * @create 2019-12-17 14:08
 */
public class SimplePizzaFactory {
    /** CheesePizza */
    private static final String PIZZA_TYPE_CHEESE = "cheese";

    /** GreekPizza */
    private static final String PIZZA_TYPE_GREEK = "greek";

    /** PepperoniPizza */
    private static final String PIZZA_TYPE_PEPPERONI = "pepperoni";

    /** ClamPizza */
    private static final String PIZZA_TYPE_CLAM = "clam";

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case PIZZA_TYPE_CHEESE:
                pizza = new CheesePizza("奶酪披萨");
                break;
            case PIZZA_TYPE_GREEK:
                pizza = new GreekPizza("希腊披萨");
                break;
            case PIZZA_TYPE_PEPPERONI:
                pizza = new PepperoniPizza("胡椒披萨");
                break;
            case PIZZA_TYPE_CLAM:
                pizza = new ClamPizza("蛤蜊披萨");
                break;
            default:
                break;
        }

        return pizza;
    }
}
