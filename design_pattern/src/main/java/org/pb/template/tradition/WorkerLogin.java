package org.pb.template.tradition;

import java.util.Objects;

/**
 * @author bo.peng
 * @create 2020-03-25 17:01
 */
public class WorkerLogin  {
    /**
     * 登录处理
     * @param lm 登录数据模型model
     * @return true表示登录成功,false表示登录失败
     */
    public boolean login(LoginModel lm) {
        /* 1.从数据库根据用户编号获取用户信息 */
        WorkerModel wm = findWorkerByUserId(lm.getUserId());

        /* 2.进行登录判断,看是否能登录成功 */
        if (Objects.nonNull(wm) && Objects.equals(wm.getWorkerId(),lm.getUserId()) && Objects.equals(wm.getPassword(),encrypt(lm.getPassword()))) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    /**
     * 对密码数据进行加密
     * @param password
     * @return
     */
    private String encrypt(String password) {
        return password;
    }

    private WorkerModel findWorkerByUserId(String workerId) {
        /* 这里省略具体的处理,仅做示意,返回一个有默认数据的对象 */
        WorkerModel wk  = new WorkerModel();
        wk.setUuid("Worker0001");
        wk.setWorkerId(workerId);
        wk.setName("test");
        wk.setPassword("test");

        return wk;
    }
}
