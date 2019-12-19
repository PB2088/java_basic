package org.pb.prototype.tradition;

/**
 * 订单处理客户端测试程序
 * @author bo.peng
 * @create 2019-12-19 16:26
 */
public class OrderClient {
    public static void main(String[] args) {
        PersonalOrder personalOrder = new PersonalOrder();

        personalOrder.setCustomerName("皮皮虾");
        personalOrder.setProductId("P001");
        personalOrder.setOrderProductNum(2952);

        OrderBusiness orderBusiness = new OrderBusiness();
        orderBusiness.createOrder(personalOrder);

        System.out.println("===========================");

        EnterpriseOrder enterpriseOrder = new EnterpriseOrder();

        enterpriseOrder.setEnterpriseName("未来科技");
        enterpriseOrder.setProductId("B002");
        enterpriseOrder.setOrderProductNum(5528);

        orderBusiness.createOrder(enterpriseOrder);
    }
}
