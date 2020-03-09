package org.pb.facade.mode;

/**
 * 示意配置管理，就是负责读取配置文件，并把配置文件的内容设置到配置Mode中去，是个单例
 * @author bo.peng
 * @create 2020-03-09 14:22
 */
public class ConfigManager {
    private static ConfigManager manager;
    private static ConfigModel cm;

    private ConfigManager() {}

    public static class ConfigManagerInstance {
        private static final ConfigManager INSTANCE = new ConfigManager();
    }

    public static ConfigManager getInstance() {
        cm = new ConfigModel();
        /*读取配置文件,把值设置到ConfigModel()中去,这里省略了*/

        return ConfigManagerInstance.INSTANCE;
    }

    public ConfigModel getConfigData() {
        return cm;
    }
}
