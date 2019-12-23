package org.pb.builder.mode.build.product;

import org.pb.util.DateUtil;

import java.util.List;
import java.util.Map;

/**
 * 导出数据到XML文件的对象
 *
 * @author bo.peng
 * @create 2019-12-20 15:55
 */
public class ExportToXmlBuilder implements ExportBuilder {
    /** 用来记录最终输出的文件内容 */
    private  StringBuilder xml = new StringBuilder();

    /**
     * 换行符
     */
    private static final String NEW_LINE = "\n";

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        System.out.println("ExportToXmlBuilder：正在构建文件Header内容....");

        /* 拼接文件头内容 */
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(NEW_LINE);
        xml.append("<Report>").append(NEW_LINE);
        xml.append("  <Header>").append(NEW_LINE);
        xml.append(String.format("   <DepartmentId>%s</DepartmentId>", ehm.getDepartmentId())).append(NEW_LINE);
        xml.append(String.format("   <DepartmentName>%s</DepartmentName>", ehm.getDepartmentName())).append(NEW_LINE);
        xml.append(String.format("   <ExportDate>%s</ExportDate>", DateUtil.parseDateToStr(ehm.getExportDate(), DateUtil.FormatPattern.DATE_TIME_FORMAT_PATTERN))).append(NEW_LINE);
        xml.append("  </Header>").append(NEW_LINE);

        System.out.println("ExportToXmlBuilder：文件Header内容构建完成！");
    }

    @Override
    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        System.out.println("ExportToXmlBuilder：正在构建文件Body内容....");

        /* 拼接文件体内容 */
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

        System.out.println("ExportToXmlBuilder：文件Body内容构建完成！");
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        System.out.println("ExportToXmlBuilder：正在构建文件Foot内容....");

        /* 拼接文件尾内容 */
        xml.append("  <Footer>").append(NEW_LINE);
        xml.append(String.format("   <ExportUser>%s</ExportUser>",efm.getExportUser())).append(NEW_LINE);
        xml.append("  </Footer>").append(NEW_LINE);

        xml.append("</Report>");

        System.out.println("ExportToXmlBuilder：文件Foot内容构建完成！");
    }

    /**
     * 获取最终构建结果
     * @return
     */
    @Override
    public String getResult() {
        System.out.printf("输出到XML文件的内容：\n%s", xml.toString());

        return xml.toString();
    }
}
