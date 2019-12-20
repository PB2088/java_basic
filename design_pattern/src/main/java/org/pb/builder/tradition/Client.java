package org.pb.builder.tradition;

import org.pb.util.DateUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bo.peng
 * @create 2019-12-20 16:55
 */
public class Client {
    public static void main(String[] args) {
        ExportHeaderModel exportHeaderModel = initExportHeaderModel();
        Map<String, List<ExportDataModel>> exportDataModelMap = initExportDataModelMap();
        ExportFooterModel exportFooterModel = initExportFooterModel();

        /*  测试输出的文本文件 */
        ExportToTxt exportToTxt = new ExportToTxt();
        exportToTxt.export(exportHeaderModel,exportDataModelMap,exportFooterModel);

        System.out.println("------------------------------------------");

        /*  测试输出的XML文件 */
        ExportToXml exportToXml = new ExportToXml();
        exportToXml.export(exportHeaderModel,exportDataModelMap,exportFooterModel);

    }

    private static ExportHeaderModel initExportHeaderModel() {
        ExportHeaderModel ehm = new ExportHeaderModel();
        ehm.setDepartmentId("B001");
        ehm.setDepartmentName("广州分公司");
        ehm.setExportDate(DateUtil.now());

        return ehm;
    }

    private static Map<String, List<ExportDataModel>> initExportDataModelMap() {
        Map<String, List<ExportDataModel>> mapData = new HashMap<>(20);

        List<ExportDataModel> exportDataModels = new ArrayList<>();

        ExportDataModel edm1 = new ExportDataModel();
        edm1.setProductId("产品001");
        edm1.setPrice(1000);
        edm1.setAmount(80);

        exportDataModels.add(edm1);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002");
        edm2.setPrice(2000);
        edm2.setAmount(79);

        exportDataModels.add(edm2);

        mapData.put("销售记录表",exportDataModels);

        return mapData;
    }

    private static ExportFooterModel initExportFooterModel() {
        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("皮皮虾");

        return efm;
    }
}
