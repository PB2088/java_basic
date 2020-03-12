package org.pb.flyweight.mode;

import org.pb.flyweight.tradition.AuthorizationModel;
import org.pb.flyweight.tradition.TestDB;
import org.pb.util.ToolsUtils;

import java.util.*;

/**
 * 安全管理，单例
 * @author bo.peng
 * @create 2020-03-10 15:19
 */
public class SecurityMgr {
    private SecurityMgr() {}

    private static class SecurityMgrInstance {
        public static final SecurityMgr INSTANCE = new SecurityMgr();
    }

    public static SecurityMgr getInstance() {
        return SecurityMgrInstance.INSTANCE;
    }

    private Map<String, List<AuthorizationFlyweight>> map = new HashMap<>();

    /**
     * 模拟登陆的功能
     * @param user
     */
    public void login(String user) {
        /* 登陆时就需要把用户所拥有的权限，从数据库中取出来，存入到缓存中 */
        List<AuthorizationFlyweight> authorizationFlyweights = selectByUser(user);
        map.put(user,authorizationFlyweights);
    }

    private List<AuthorizationFlyweight> selectByUser(String user) {
        List<AuthorizationFlyweight> authorizationFlyweights = new ArrayList<>();

        TestDB.colDB.stream().forEach(s -> {
            String[] ss = s.split(",");
            if (Objects.equals(ss[0],user)) {
                AuthorizationFlyweight am  = new AuthorizationFlyweight(user);

                authorizationFlyweights.add(am);
            }
        });

        return authorizationFlyweights;
    }

    /**
     * 判断某个用户对某个安全实例是否拥有某种权限
     * @param user 被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return true 表示拥有相应的权限,false表示没有相应的权限
     */
    public boolean hasPermit(String user,String securityEntity,String permit) {
        List<AuthorizationFlyweight> authorizationFlyweights = map.get(user);

        if (ToolsUtils.isEmpty(authorizationFlyweights)) {
            System.out.printf("%s没有登陆或没有被分配任何权限\n",user);
            return Boolean.FALSE;
        }

        for (AuthorizationFlyweight authorizationFlyweight : authorizationFlyweights) {
            System.out.println("AuthorizationFlyweight==" + authorizationFlyweight);
            if (authorizationFlyweight.match(securityEntity,permit)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}
