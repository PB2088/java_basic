package org.pb.facade.mode;

import org.pb.facade.tradition.ConfigManager;
import org.pb.facade.tradition.ConfigModel;

/**
 * 示意生成DAO层的模块
 * @author bo.peng
 * @create 2020-03-09 14:45
 */
public class Dao {
    /**
     * 生成DAO层的代码,并生成文件保存
     */
    public void generate() {
        /*1.从配置管理里面获取相应的配置信息*/
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenBusiness()) {
            /*2.按照要求去生成相应的代码，并保存成文件*/
            System.out.println("正在DAO层代码文件...");
        }
    }
}
