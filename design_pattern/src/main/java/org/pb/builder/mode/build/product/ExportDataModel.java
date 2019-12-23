package org.pb.builder.mode.build.product;

/**
 * 导出文件数据内容对象
 * @author bo.peng
 * @create 2019-12-20 15:51
 */
public class ExportDataModel {
    /** 产品编号 */
    private String productId;

    /** 销售价格(单位：分) */
    private long price;

    /** 销售数量 */
    private long amount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
