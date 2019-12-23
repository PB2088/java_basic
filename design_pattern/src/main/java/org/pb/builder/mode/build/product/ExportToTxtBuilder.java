package org.pb.builder.mode.build.product;

import org.pb.util.DateUtil;

import java.util.List;
import java.util.Map;

/**
 * 导出数据到文本文件的生成器对象
 * @author bo.peng
 * @create 2019-12-23 15:55
 */
public class ExportToTxtBuilder implements ExportBuilder {
    private StringBuilder buffer = new StringBuilder();

    /** 换行符 */
    private static final String NEW_LINE = "\n";

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        System.out.println("ExportToTxtBuilder：正在构建文件Header内容....");

        buffer.append(String.format("%s,%s,%s",ehm.getDepartmentId(),ehm.getDepartmentName(), DateUtil.parseDateToStr(ehm.getExportDate(), DateUtil.FormatPattern.DATE_TIME_FORMAT_PATTERN))).append(NEW_LINE);

        System.out.println("ExportToTxtBuilder：文件Header内容构建完成！");
    }

    @Override
    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        System.out.println("ExportToTxtBuilder：正在构建文件Body内容....");

        for (String tblName : mapData.keySet()) {
            /* 拼接表名称 */
            buffer.append(String.format("%s",tblName)).append(NEW_LINE);

            /* 拼接具体数据内容 */
            for (ExportDataModel exportDataModel : mapData.get(tblName)) {
                buffer.append(String.format("%s,%s,%s",exportDataModel.getProductId(),exportDataModel.getPrice()/100,exportDataModel.getAmount())).append(NEW_LINE);
            }
        }

        System.out.println("ExportToTxtBuilder：文件Body内容构建完成！");
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        System.out.println("ExportToTxtBuilder：正在构建文件Foot内容....");

        /* 拼接文件尾内容 */
        buffer.append(efm.getExportUser()).append(NEW_LINE);

        System.out.println("ExportToTxtBuilder：文件Foot内容构建完成！");
    }

    /**
     * 获取最终构建结果
     * @return
     */
    @Override
    public String getResult() {
        System.out.printf("输出到文本文件的内容：\n%s", buffer.toString());

        return buffer.toString();
    }
}
