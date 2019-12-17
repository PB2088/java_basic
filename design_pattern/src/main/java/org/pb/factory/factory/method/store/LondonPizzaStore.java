package org.pb.factory.factory.method.store;

import org.pb.factory.factory.method.pizza.*;

/**
 * @author bo.peng
 * @create 2019-12-17 15:20
 */
public class LondonPizzaStore extends PizzaStore {
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
                pizza = new LondonCheesePizza("伦敦风味奶酪披萨");
                break;
            case PIZZA_TYPE_GREEK:
                pizza = new LondonGreekPizza("伦敦风味希腊披萨");
                break;
            case PIZZA_TYPE_PEPPERONI:
                pizza = new LondonPepperoniPizza("伦敦风味胡椒披萨");
                break;
            case PIZZA_TYPE_CLAM:
                pizza = new LondonClamPizza("伦敦风味蛤蜊披萨");
                break;
            default:
                break;
        }

        return pizza;
    }

    @Override
    public void orderPizza() {
        System.out.println("欢迎光临伦敦披萨店!");
        super.orderPizza();
    }
}
