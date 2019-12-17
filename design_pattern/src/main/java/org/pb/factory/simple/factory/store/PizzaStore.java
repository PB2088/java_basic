package org.pb.factory.simple.factory.store;

import org.pb.factory.simple.factory.factory.SimplePizzaFactory;
import org.pb.factory.simple.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author bo.peng
 * @create 2019-12-15 17:18
 */
public class PizzaStore {
    private SimplePizzaFactory pizzaFactory;

    public PizzaStore(SimplePizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    /**
     * 订购披萨
     */
    public void orderPizza() {
        while (Boolean.TRUE) {
            String type = getPizzaType();

            Pizza pizza = pizzaFactory.createPizza(type);

            if (Objects.isNull(pizza)) {
                System.out.println("对不起暂时没有这种披萨");
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }

        }
    }

    private String getPizzaType() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入要订购的披萨：");
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        pizzaStore.orderPizza();
    }
}
