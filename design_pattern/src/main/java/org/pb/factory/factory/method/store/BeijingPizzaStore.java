package org.pb.factory.factory.method.store;

import org.pb.factory.factory.method.pizza.*;

/**
 * @author bo.peng
 * @create 2019-12-17 15:20
 */
public class BeijingPizzaStore extends PizzaStore {
    /** CheesePizza */
    private static final String PIZZA_TYPE_CHEESE = "cheese";

    /** GreekPizza */
    private static final String PIZZA_TYPE_GREEK = "greek";

    /** PepperoniPizza */
    private static final String PIZZA_TYPE_PEPPERONI = "pepperoni";

    /** ClamPizza */
    private static final String PIZZA_TYPE_CLAM = "clam";

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case PIZZA_TYPE_CHEESE:
                pizza = new BeijingCheesePizza("北京风味奶酪披萨");
                break;
            case PIZZA_TYPE_GREEK:
                pizza = new BeijingGreekPizza("北京风味希腊披萨");
                break;
            case PIZZA_TYPE_PEPPERONI:
                pizza = new BeijingPepperoniPizza("北京风味胡椒披萨");
                break;
            case PIZZA_TYPE_CLAM:
                pizza = new BeijingClamPizza("北京风味蛤蜊披萨");
                break;
            default:
                break;
        }

        return pizza;
    }

    @Override
    public void orderPizza() {
        System.out.println("欢迎光临北京披萨店!");
        super.orderPizza();
    }
}
