package org.pb.template.tradition;

import java.util.Objects;

/**
 * 普通用户登陆控制的逻辑处理
 * @author bo.peng
 * @create 2020-03-25 16:42
 */
public class NormalLogin {
    /**
     * 登录处理
     * @param lm 登录数据模型model
     * @return true表示登录成功,false表示登录失败
     */
    public boolean login(LoginModel lm) {
        /* 1.从数据库根据用户编号获取用户信息 */
        UserModel um = findUserByUserId(lm.getUserId());

        /* 2.进行登录判断,看是否能登录成功 */
        if (Objects.nonNull(um) && Objects.equals(um.getUserId(),lm.getUserId()) && Objects.equals(um.getPassword(),lm.getPassword())) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    /**
     * 根据用户编号获取用户的详细信息
     * @param userId 用户编号
     * @return 用户信息数据模型
     */
    private UserModel findUserByUserId(String userId) {
        /* 这里省略具体的处理,仅做示意,返回一个有默认数据的对象 */
        UserModel um  = new UserModel();
        um.setUuid("User0001");
        um.setUserId(userId);
        um.setName("test");
        um.setPassword("test");

        return um;
    }
}
