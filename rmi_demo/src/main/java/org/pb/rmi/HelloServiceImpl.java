package org.pb.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author boge.peng
 * @create 2018-12-25 21:21
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {
    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException {
        return "Hello," +msg;
    }
}
