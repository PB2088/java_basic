package org.pb.prototype.tradition;

/**
 * @author bo.peng
 * @create 2019-12-19 14:53
 */
public class EnterpriseOrder implements OrderApi {
    /** 订购人姓名 */
    private String enterpriseName;

    /** 产品编号 */
    private String productId;

    /** 订单产品数量 */
    private int orderProductNum;

    @Override
    public int getOrderProductNum() {
        return orderProductNum;
    }

    @Override
    public void setOrderProductNum(int orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return String.format("本企业订单的订购企业是%s,订购产品编号是%s,订购数量为%d",enterpriseName,productId,orderProductNum);
    }
}
