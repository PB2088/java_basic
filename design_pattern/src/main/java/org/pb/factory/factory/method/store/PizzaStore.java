package org.pb.factory.factory.method.store;

import org.pb.factory.factory.method.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author bo.peng
 * @create 2019-12-15 17:18
 */
public abstract class PizzaStore {

    /**
     * 订购披萨
     */
    public void orderPizza() {
        while (Boolean.TRUE) {
            String type = getPizzaType();

            Pizza pizza = createPizza(type);

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

    /**
     * 根据客户选择类型,创建相应的披萨,具体由子类实现
     *
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);


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
        PizzaStore pizzaStore = new BeijingPizzaStore();
        pizzaStore.orderPizza();
    }
}
