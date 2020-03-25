package org.pb.template.tradition;

/**
 * 描述工作人员信息的数据模型
 * @author bo.peng
 * @create 2020-03-25 17:05
 */
public class WorkerModel {
    /** UUID */
    private String uuid;

    /** 工作人员ID */
    private String workerId;

    /** 登录密码 */
    private String password;

    /** 用户名 */
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
