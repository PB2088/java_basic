package org.pb.prototype.mode;

/**
 * 订单处理客户端测试程序
 * @author bo.peng
 * @create 2019-12-19 16:26
 */
public class OrderClient {
    public static void main(String[] args) {
        System.out.println("通过原型模式改进的订单处理");

        System.out.println("============个人订单===============");
        PersonalOrder personalOrder = new PersonalOrder();

        personalOrder.setCustomerName("皮皮虾");
        personalOrder.setProductId("P001");
        personalOrder.setOrderProductNum(2952);

        OrderBusiness orderBusiness = new OrderBusiness();
        orderBusiness.createOrder(personalOrder);

        System.out.println("============企业订单===============");

        EnterpriseOrder enterpriseOrder = new EnterpriseOrder();

        enterpriseOrder.setEnterpriseName("未来科技");
        enterpriseOrder.setProductId("B002");
        enterpriseOrder.setOrderProductNum(5528);

        orderBusiness.createOrder(enterpriseOrder);

        System.out.println("============大客户订单===============");

        BigCustomerOrder bigCustomerOrder = new BigCustomerOrder();

        bigCustomerOrder.setCustomerName("土豪波");
        bigCustomerOrder.setProductId("BG001");
        bigCustomerOrder.setOrderProductNum(8888);

        orderBusiness.createOrder(bigCustomerOrder);

    }
}
