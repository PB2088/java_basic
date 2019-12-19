package org.pb.prototype.mode;

/**
 * 订单的接口
 *
 * @author bo.peng
 * @create 2019-12-19 14:44
 */
public interface OrderApi {
    /**
     * 获取订单产品数量
     * @return 订单中产品数量
     */
    int getOrderProductNum();

    /**
     * 设置订单产品数量
     * @param orderProductNum 订单产品数量
     */
    void setOrderProductNum(int orderProductNum);

    /**
     * 克隆订单
     * @return 订单原型的实例对象
     */
    OrderApi cloneOrder();
}
