package org.pb.prototype.mode;

import java.util.Map;

/**
 * 处理订单业务
 *
 * @author bo.peng
 * @create 2019-12-19 14:56
 */
public class OrderBusiness {
    /**
     * 每个订单最大产品数量
     */
    public static final int MAX_ORDER_PRODUCT_NUM = 1000;

    /**
     * 创建订单
     *
     * @param order
     */
    public void createOrder(OrderApi order) {
        /* 1.判断当前订单的预定产品数量是否大于1000 */
        while (order.getOrderProductNum() > MAX_ORDER_PRODUCT_NUM) {
            /* 2.如果当前订单的预定产品数量大于1000,则需要继续拆分 */
            /* 2.1 再创建一份订单,跟传入的订单除了数量不一样外,其他都相同 */
            OrderApi newOrder = order.cloneOrder();
            newOrder.setOrderProductNum(MAX_ORDER_PRODUCT_NUM);

            /* 2.2 原来的订单保留,把订单产品数量减少1000 */
            order.setOrderProductNum(order.getOrderProductNum() - MAX_ORDER_PRODUCT_NUM);

            /* 然后是业务功能处理,这里省略了,打印输出,看一下 */
            System.out.printf("拆分生成订单：%s\n",newOrder.toString());
        }

        /* 3 不超过1000,则进行业务功能处理,这里省略了,打印输出,看一下 */
        System.out.printf("订单：%s\n",order.toString());
    }
}
