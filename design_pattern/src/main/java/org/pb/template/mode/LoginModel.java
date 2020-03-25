package org.pb.template.mode;

/**
 * 封装登录控制所需要的数据
 * @author bo.peng
 * @create 2020-03-25 22:59
 */
public class LoginModel {
    /** 登录人员的编号,通用的,可能是用户编号,也可能是工作人员编号 */
    private String loginId;

    /** 登录密码 */
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
