package org.pb.facade.mode;

/**
 * 代码生成系统的外观对象
 * @author bo.peng
 * @create 2020-03-09 15:12
 */
public class Facade {
    public void generate() {
        new Presentation().generate();
        new Business().generate();
        new Dao().generate();
    }
}
