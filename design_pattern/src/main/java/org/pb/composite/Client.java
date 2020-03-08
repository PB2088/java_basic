package org.pb.composite;

/**
 * @author bo.peng
 * @create 2020-03-02 15:06
 */
public class Client {
    public static void main(String[] args) {
        /* 创建学校 */
        University university = new University("清华大学", " 中国顶级大学");

        /* 创建学院 */
        College computerCollege = new College("计算机学院", " 计算机学院");
        College infoEngineerCollege = new College("信息工程学院", " 信息工程学院");

        /* 创建各个学院正面的系 */
        computerCollege.add(new Department("软件工程"," 软件工程不错"));
        computerCollege.add(new Department("网络工程"," 网络工程不错"));
        computerCollege.add(new Department("计算机科学与技术"," 计算机科学与技术是老牌的专业"));

        infoEngineerCollege.add(new Department("通信工程"," 通信工程不怎么好学啊"));
        infoEngineerCollege.add(new Department("信息工程"," 信息工程还是挺好学的"));

        university.add(computerCollege);
        university.add(infoEngineerCollege);

        university.print();

    }
}
