package org.pb.flyweight.tradition;

/**
 * @author bo.peng
 * @create 2020-03-10 16:21
 */
public class Client {
    public static void main(String[] args) {
        /*需要先登陆,再判断是否有权限*/
        SecurityMgr mgr = SecurityMgr.getInstance();
        mgr.login("张三");
        mgr.login("李四");

        boolean hasPermit = mgr.hasPermit("张三", "薪资数据", "查看");
        boolean hasPermit1 = mgr.hasPermit("李四", "薪资数据", "查看");

        System.out.println(hasPermit);
        System.out.println(hasPermit1);

    }
}
