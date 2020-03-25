package org.pb.template.mode;

/**
 * 客户端测试
 * @author bo.peng
 * @create 2020-03-25 23:36
 */
public class Client {
    public static void main(String[] args) {
        /* 准备登录人信息 */
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPassword("workerpwd");

        WorkerLogin login = new WorkerLogin();
        boolean flag = login.login(lm);

        if (flag) {
            System.out.printf("登录成功,%s用户可以登录工作平台\n", lm.getLoginId());
        } else {
            System.out.printf("登录失败! 用户名或密码错误!");
        }

        NormalLogin normalLogin = new NormalLogin();
        boolean isSuccess = normalLogin.login(lm);

        if (isSuccess) {
            System.out.printf("用户%s进行普通人员登录成功\n", lm.getLoginId());
        } else {
            System.out.printf("用户%s进行普通人员登录失败\n", lm.getLoginId());
        }

    }
}
