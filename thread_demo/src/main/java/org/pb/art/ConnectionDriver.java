package org.pb.art;

import org.pb.util.SleepUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2019-04-01 21:17
 */
public class ConnectionDriver {

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new
                ConnectionHandler());
    }

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Objects.equals(method.getName(), "commit")) {
                SleepUtils.second(100);
            }
            return null;
        }
    }
}
