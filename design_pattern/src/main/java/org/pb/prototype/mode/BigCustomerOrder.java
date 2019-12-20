package org.pb.prototype.mode;

/**
 * 大客户订单对象
 * @author bo.peng
 * @create 2019-12-19 16:47
 */
public class BigCustomerOrder implements OrderApi {
    /** 订购人姓名 */
    private String customerName;

    /** 产品编号 */
    private String productId;

    /** 订单产品数量 */
    private int orderProductNum;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public int getOrderProductNum() {
        return orderProductNum;
    }

    @Override
    public void setOrderProductNum(int orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    @Override
    public OrderApi cloneOrder() {
        BigCustomerOrder newOrder = new BigCustomerOrder();

        newOrder.customerName = this.customerName;
        newOrder.productId = this.productId;
        newOrder.orderProductNum = this.orderProductNum;

        return newOrder;
    }

    @Override
    public String toString() {
        return String.format("本大客户订单的订购人是%s,订购产品编号是%s,订购数量为%d",customerName,productId,orderProductNum);
    }
}