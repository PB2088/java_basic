package org.pb.facade.mode;

/**
 * 示意配置描述的数据Model,真实的配置数据会很多
 * @author bo.peng
 * @create 2020-03-09 14:15
 */
public class ConfigModel {
    /** 是否需要生成表现层,默认是true */
    private boolean needGenPresentation = true;

    /** 是否需要生成业务逻辑层,默认是true */
    private boolean needGenBusiness = true;

    /** 是否需要生成DAO层，默认是true */
    private boolean needGenDAO = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation(boolean needGenPresentation) {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDAO() {
        return needGenDAO;
    }

    public void setNeedGenDAO(boolean needGenDAO) {
        this.needGenDAO = needGenDAO;
    }
}
