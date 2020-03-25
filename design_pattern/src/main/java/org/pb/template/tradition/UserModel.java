package org.pb.template.tradition;

/**
 * 描述用户信息的数据模型
 * @author bo.peng
 * @create 2020-03-25 16:49
 */
public class UserModel {
    /** UUID */
    private String uuid;

    /** 用户ID */
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
