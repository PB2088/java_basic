package org.pb.builder.mode.build.product;

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

        ExportToTxtBuilder exportToTxtBuilder = new ExportToTxtBuilder();

        Director director = new Director(exportToTxtBuilder);
        director.construct(exportHeaderModel,exportDataModelMap,exportFooterModel);
        director.showBuilderResult();

        System.out.println("------------------------------------------");
        ExportToXmlBuilder exportToXmlBuilder = new ExportToXmlBuilder();
        director.setBuilder(exportToXmlBuilder);
        director.construct(exportHeaderModel,exportDataModelMap,exportFooterModel);
        director.showBuilderResult();
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
        edm1.setPrice(100000);
        edm1.setAmount(80);

        exportDataModels.add(edm1);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002");
        edm2.setPrice(200000);
        edm2.setAmount(79);

        exportDataModels.add(edm2);

        ExportDataModel edm3 = new ExportDataModel();
        edm3.setProductId("产品003");
        edm3.setPrice(300000);
        edm3.setAmount(120);

        exportDataModels.add(edm3);

        mapData.put("销售记录表",exportDataModels);

        return mapData;
    }

    private static ExportFooterModel initExportFooterModel() {
        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("皮皮虾");

        return efm;
    }
}
