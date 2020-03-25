package org.pb.template.mode;

/**
 * 普通用户登录逻辑处理
 * @author bo.peng
 * @create 2020-03-25 23:28
 */
public class NormalLogin extends LoginTemplate {
    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();

        lm.setLoginId(loginId);
        lm.setPassword("testpwd");

        return lm;
    }
}
