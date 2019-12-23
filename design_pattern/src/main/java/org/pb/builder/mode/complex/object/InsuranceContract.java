package org.pb.builder.mode.complex.object;

/**
 * @author bo.peng
 * @create 2019-12-23 16:08
 */
public class InsuranceContract {
    /** 保险合同ID */
    private String contractId;

    /** 被保险人名称 */
    private String personName;

    /** 生效时间(格式：yyyy-MM-dd HH:mm:ss) */
    private String effectiveDate;

    /** 失效时间(格式：yyyy-MM-dd HH:mm:ss) */
    private String expirationDate;

    /** 示例：其他数据 */
    private String otherData;

    private InsuranceContract(InsuranceContractBuilder build) {
        this.contractId = build.contractId;
        this.effectiveDate = build.effectiveDate;
        this.expirationDate = build.expirationDate;
        this.personName = build.personName;
        this.otherData = build.otherData;
    }

    public void someOperation() {
        System.out.printf("InsuranceContract[contractId=%s,personName=%s,effectiveDate=%s,expirationDate=%s,otherData=%s]", contractId, personName, effectiveDate, expirationDate, otherData);
    }

    public static class InsuranceContractBuilder {
        /** 保险合同ID */
        private String contractId;

        /** 被保险人名称 */
        private String personName;

        /** 生效时间(格式：yyyy-MM-dd HH:mm:ss) */
        private String effectiveDate;

        /** 失效时间(格式：yyyy-MM-dd HH:mm:ss) */
        private String expirationDate;

        /** 示例：其他数据 */
        private String otherData;

        /**
         * 构建器构造方法：传入必必要有的参数
         * @param contractId 保险合同编号
         * @param effectiveDate 保险生效日期
         * @param expirationDate 保险失效日期
         */
        public InsuranceContractBuilder(String contractId, String effectiveDate, String expirationDate) {
            this.contractId = contractId;
            this.effectiveDate = effectiveDate;
            this.expirationDate = expirationDate;
        }

        public InsuranceContractBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public InsuranceContractBuilder otherData(String otherData) {
            this.otherData = otherData;
            return this;
        }

        public InsuranceContract build() {
            return new InsuranceContract(this);
        }

    }
}
