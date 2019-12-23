package org.pb.builder.mode.build.product;

import java.util.List;
import java.util.Map;

/**
 * 导出生成器接口,定义创建一个输出文件对象所需的各个部件的操作
 * @author bo.peng
 * @create 2019-12-23 14:22
 */
public interface ExportBuilder {
    /**
     * 构建输出文件的Header部分
     * @param ehm 文件头内容
     */
    void buildHeader(ExportHeaderModel ehm);

    /**
     * 构建输出文件的Body部分
     * @param mapData 要输出的数据的内容
     */
    void buildBody(Map<String, List<ExportDataModel>> mapData);

    /**
     * 构建输出文件的Footer部分
     * @param efm 文件尾的内容
     */
    void buildFooter(ExportFooterModel efm);

    /**
     * 最终构建结果
     * @return
     */
    String getResult();
}
