package StructuralPattern.M_Proxy.rmi;

import java.rmi.*;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}
