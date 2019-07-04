package org.pb.reflection.bean;

import org.pb.annotation.Column;
import org.pb.annotation.Table;

import java.util.Date;

/**
 * @author boge.peng
 * @create 2018-12-26 10:17
 */
@Table(value = "tbl_employees")
public class Employee {
    @Column(columnName = "id",type = "int",length = 10)
    private int oid;
    @Column(columnName = "emp_no",type = "varchar",length = 50)
    private String empNo;
    @Column(columnName = "ename",type = "varchar",length = 50)
    private String ename;
    @Column(columnName = "salary",type = "number",length = 17)
    private double salary;
    @Column(columnName = "hireDate",type = "date",length = 50)
    private Date hireDate;
    @Column(columnName = "dept_no",type = "int",length = 10)
    private int dept_no;

    public  String testField;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }
}
