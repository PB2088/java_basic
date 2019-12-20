package org.pb.builder.tradition;

import java.util.Date;

/**
 * 导出文件头内容对象
 *
 * @author bo.peng
 * @create 2019-12-20 15:47
 */
public class ExportHeaderModel {
    /**
     * 部门编号
     */
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 导出数据的日期
     */
    private Date exportDate;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }
}
