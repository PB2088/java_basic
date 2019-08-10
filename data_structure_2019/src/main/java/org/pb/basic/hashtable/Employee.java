package org.pb.basic.hashtable;

/**
 * @author boge.peng
 * @create 2019-08-07 23:43
 */
public class Employee {
    /**
     * 员工编号
     */
    private int num;

    /**
     * 员工姓名
     */
    private String name;

    public Employee() {}

    public Employee(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
