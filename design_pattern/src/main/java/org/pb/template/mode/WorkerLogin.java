package org.pb.template.mode;

/**
 * @author bo.peng
 * @create 2020-03-25 23:30
 */
public class WorkerLogin extends LoginTemplate {
    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();

        lm.setLoginId(loginId);
        lm.setPassword("workerpwd");

        return lm;
    }

    @Override
    public String encrypt(String password) {
        /* 覆盖父类的方法,提供真正的加密实现 */
        /* 这里对密码进行加密,比如使用MD5,3DES等，省略了 */
        System.out.println("使用MD5对密码进行加密");

        return password;
    }
}
