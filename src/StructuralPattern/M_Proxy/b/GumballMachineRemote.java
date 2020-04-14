package StructuralPattern.M_Proxy.b;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
	public Integer getCount() throws RemoteException;

	public String getLocation() throws RemoteException;
 
	public State getState() throws RemoteException;
}
