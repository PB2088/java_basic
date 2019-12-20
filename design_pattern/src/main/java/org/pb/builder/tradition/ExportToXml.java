package org.pb.builder.tradition;

import org.pb.util.DateUtil;

import java.util.List;
import java.util.Map;

/**
 * 导出数据到XML文件的对象
 *
 * @author bo.peng
 * @create 2019-12-20 15:55
 */
public class ExportToXml {
    /**
     * 换行符
     */
    public static final String NEW_LINE = "\n";

    /**
     * 导出数据到文本文件
     *
     * @param ehm     文件头内容
     * @param mapData 数据内容
     * @param efm     文件尾内容
     */
    public void export(ExportHeaderModel ehm, Map<String, List<ExportDataModel>> mapData, ExportFooterModel efm) {
        /* 用来记录最终输出的文件内容 */
        StringBuilder xml = new StringBuilder();

        /* 1.拼接文件头内容 */
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(NEW_LINE);
        xml.append("<Report>").append(NEW_LINE);
        xml.append("  <Header>").append(NEW_LINE);
        xml.append(String.format("   <DepartmentId>%s</DepartmentId>", ehm.getDepartmentId())).append(NEW_LINE);
        xml.append(String.format("   <DepartmentName>%s</DepartmentName>", ehm.getDepartmentName())).append(NEW_LINE);
        xml.append(String.format("   <ExportDate>%s</ExportDate>", DateUtil.parseDateToStr(ehm.getExportDate(), DateUtil.FormatPattern.DATE_TIME_FORMAT_PATTERN))).append(NEW_LINE);
        xml.append("  </Header>").append(NEW_LINE);

        /* 2.拼接文件体内容 */
        xml.append("  <Body>").append(NEW_LINE);
        for (String tblName : mapData.keySet()) {
            xml.append(String.format("  <Datas TableName=\"%s\">", tblName)).append(NEW_LINE);
            for (ExportDataModel exportDataModel : mapData.get(tblName)) {
                xml.append("   <Data>").append(NEW_LINE);
                xml.append(String.format("    <ProductId>%s</ProductId>",exportDataModel.getProductId())).append(NEW_LINE);
                xml.append(String.format("    <Price>%s</Price>",exportDataModel.getPrice()/100)).append(NEW_LINE);
                xml.append(String.format("    <Amount>%s</Amount>",exportDataModel.getAmount())).append(NEW_LINE);
                xml.append("   </Data>").append(NEW_LINE);
            }
            xml.append("  </Datas>").append(NEW_LINE);
        }
        xml.append("  </Body>").append(NEW_LINE);

        /* 3.拼接文件尾内容 */
        xml.append("  <Footer>").append(NEW_LINE);
        xml.append(String.format("   <ExportUser>%s</ExportUser>",efm.getExportUser())).append(NEW_LINE);
        xml.append("  </Footer>").append(NEW_LINE);

        xml.append("</Report>");

        System.out.printf("输出到XML文件的内容：\n%s", xml.toString());
    }
}
