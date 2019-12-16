package org.pb.factory.tradition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author bo.peng
 * @create 2019-12-15 17:18
 */
public class PizzaStore {

    public static void main(String[] args) {
        PizzaStore ps = new PizzaStore();
        ps.orderPizza();
    }

    /**
     * 订购披萨
     */
    public void orderPizza() {
        while (Boolean.TRUE) {
            String type = getPizzaType();

            Pizza pizza = null;
            if (Objects.equals("Greek",type)) {
                pizza = new GreekPizza("希腊");
            } else if (Objects.equals("Cheese",type)) {
                pizza = new CheesePizza("奶酪");
            } else {
                break;
            }

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
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
}
