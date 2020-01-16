package org.pb.decorator.example;

/**
 * @author bo.peng
 * @create 2020-01-16 14:18
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        /* 订一杯浓缩咖啡，不需要调料 */
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() +"\t" +espresso.cost());

        /* 订一杯烘焙咖啡，加两份摩卡，一份奶泡 */
        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() +"\t" +darkRoast.cost());

        /* 最后来一杯调料为豆浆，摩卡，奶泡的综合咖啡 */
        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);

        System.out.println(houseBlend.getDescription() +"\t" +houseBlend.cost());
    }
}
