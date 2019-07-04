package org.pb.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author boge.peng
 * @create 2018-12-25 21:20
 */
public interface IHelloService extends Remote{
    String sayHello(String msg) throws RemoteException;
}
