package org.pb.builder.mode.build.product;

import java.util.List;
import java.util.Map;

/**
 * 指导者,指导使用生成器的接口来构建输出的文件的对象
 * @author bo.peng
 * @create 2019-12-23 14:43
 */
public class Director {
    private ExportBuilder builder;

    public Director(ExportBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(ExportBuilder builder) {
        this.builder = builder;
    }

    /**
     * 指导生成器构建最终的输出的文件
     * @param ehm
     * @param mapData
     * @param efm
     */
    public void construct(ExportHeaderModel ehm, Map<String, List<ExportDataModel>> mapData, ExportFooterModel efm) {
        /* 先建构Header */
        builder.buildHeader(ehm);
        /* 然后构建Body */
        builder.buildBody(mapData);
        /* 最后构建Footer */
        builder.buildFooter(efm);
    }

    public void showBuilderResult() {
        builder.getResult();
    }
}
