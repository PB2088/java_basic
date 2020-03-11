package org.pb.flyweight.mode;

import java.util.Objects;

/**
 * 封装授权数据中重复出现部分的享元对象
 * @author bo.peng
 * @create 2020-03-11 17:05
 */
public class AuthorizationFlyweight implements Flyweight {
    /** 内部状态：安全实体 */
    private String securityEntity;

    /** 内部状态：权限 */
    private String permit;

    public AuthorizationFlyweight(String state) {
        String[] ss = state.split(",");
        securityEntity = ss[0];
        permit = ss[1];
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        if (Objects.equals(securityEntity,this.securityEntity) && Objects.equals(permit,this.permit)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public String getPermit() {
        return permit;
    }
}
