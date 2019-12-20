package org.pb.builder.tradition;

import org.pb.util.DateUtil;

import java.util.List;
import java.util.Map;

/**
 * 导出数据到文本文件的对象
 * @author bo.peng
 * @create 2019-12-20 15:55
 */
public class ExportToTxt {
    /** 换行符 */
    public static final String NEW_LINE = "\n";

    /**
     * 导出数据到文本文件
     * @param ehm 文件头内容
     * @param mapData 数据内容
     * @param efm 文件尾内容
     */
    public void export(ExportHeaderModel ehm, Map<String, List<ExportDataModel>> mapData,ExportFooterModel efm) {
        /* 用来记录最终输出的文件内容 */
        StringBuilder text = new StringBuilder();

        /* 1.拼接文件头内容 */
        text.append(String.format("%s,%s,%s",ehm.getDepartmentId(),ehm.getDepartmentName(), DateUtil.parseDateToStr(ehm.getExportDate(), DateUtil.FormatPattern.DATE_TIME_FORMAT_PATTERN))).append(NEW_LINE);

        /* 2.拼接文件体内容 */
        for (String tblName : mapData.keySet()) {
            /* 拼接表名称 */
            text.append(String.format("%s",tblName)).append(NEW_LINE);

            /* 拼接具体数据内容 */
            for (ExportDataModel exportDataModel : mapData.get(tblName)) {
                text.append(String.format("%s,%s,%s",exportDataModel.getProductId(),exportDataModel.getPrice()/100,exportDataModel.getAmount())).append(NEW_LINE);
            }

            /* 拼接文件尾内容 */
            text.append(efm.getExportUser()).append(NEW_LINE);

            /* 为了演示的简洁性,这里不再编写输出的文件的代码,把要输出的内容输出到控制台 */
            System.out.printf("输出到文本文件的内容：\n%s", text.toString());
        }
    }
}
