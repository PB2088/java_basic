package org.pb.facade.mode;

/**
 * 外观模式客户端
 * @author bo.peng
 * @create 2020-03-09 14:52
 */
public class Client {
    public static void main(String[] args) {
        /*现在没有配置文件,直接使用默认的配置,通常情况下,三层都应该生成,也就是说客户端必须对这些模块都有了解,才能够正确使用他们*/
        new Facade().generate();
    }
}
