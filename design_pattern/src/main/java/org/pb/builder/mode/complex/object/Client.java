package org.pb.builder.mode.complex.object;

/**
 * @author bo.peng
 * @create 2019-12-23 17:01
 */
public class Client {
    public static void main(String[] args) {
        InsuranceContract.InsuranceContractBuilder builder = new InsuranceContract.InsuranceContractBuilder("001","2019-12-11 17:00:11","2020-12-10 17:00:11");
        builder.personName("张三").otherData("1212111");

        InsuranceContract insuranceContract = builder.build();

        insuranceContract.someOperation();
    }
}
