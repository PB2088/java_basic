package org.pb.facade.mode;

/**
 * 示意生成表现层的模块
 * @author bo.peng
 * @create 2020-03-09 14:45
 */
public class Presentation {
    /**
     * 生成表现层的代码,并生成文件保存
     */
    public void generate() {
        /*1.从配置管理里面获取相应的配置信息*/
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenPresentation()) {
            /*2.按照要求去生成相应的代码，并保存成文件*/
            System.out.println("正在生成表现层代码文件...");
        }
    }
}
