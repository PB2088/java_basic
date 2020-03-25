package org.pb.template.tradition;

/**
 * 登录人员登录时填写的信息数据模型
 * @author bo.peng
 * @create 2020-03-25 16:43
 */
public class LoginModel {
    /** 登录用户ID */
    private String userId;

    /** 登录密码 */
    private String password;

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
}
