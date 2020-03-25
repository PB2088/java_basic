package org.pb.template.mode;

import java.util.Objects;

/**
 * 登录控制模板
 * @author bo.peng
 * @create 2020-03-25 23:01
 */
public abstract class LoginTemplate {
    /**
     * 登录业务逻辑处理
     * @param loginModel 封装好的登录数据model
     * @return true登录成功,false登录失败
     */
    public final boolean login(LoginModel loginModel) {
        /* 根据登录人员的编号去获取相应的数据 */
        LoginModel dblm = findLoginUser(loginModel.getLoginId());

        if (Objects.nonNull(dblm)) {
            String encryptPassword = encrypt(loginModel.getPassword());
            /* 把加密后的数据设置到登录数据模型中 */
            loginModel.setPassword(encryptPassword);

            /* 判断登录是否成功 */
            return match(loginModel,dblm);
        }

        return false;
    }

    /**
     * 判断用户填写的登录数据和数据库中是否匹配
     * @param loginModel 用户填写的登录数据
     * @param dblm 数据库中对应的用户数据
     * @return true表示登录成功,false表示登录失败
     */
    public boolean match(LoginModel loginModel, LoginModel dblm) {
        return Objects.equals(loginModel.getLoginId(),dblm.getLoginId())
                && Objects.equals(loginModel.getPassword(),dblm.getPassword());
    }

    public String encrypt(String password) {
        return password;
    }

    /**
     * 根据登录编号查找数据库中对应的用户数据,具体由子类实现
     * @param loginId 登录密码
     * @return 数据库中存在对应的数据
     */
    public abstract LoginModel findLoginUser(String loginId);
}
