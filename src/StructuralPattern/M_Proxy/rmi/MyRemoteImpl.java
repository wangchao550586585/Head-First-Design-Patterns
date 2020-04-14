package StructuralPattern.M_Proxy.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


/**
 * 1:制作远程接口 定义接口继承remote, 声明所有方法抛出RemoteException 变量以及返回值属于原语类型或可序列化 
 * 2：制作远程实现实现接口，成为远程服务对象简单继承UnicastRemoteObject
 * 				UnicastRemoteObject构造器会抛出异常，所以实现类提供构造抛出异常
 * 				实例化后，注册Naming.rebind,RMI注册的是stub(需要提前启动RMI Registry) 
 * 3:产生stub和skeleton:rmic MyRemoteImpl 
 * 4:执行:rmiregistry 
 * 5:启动服务:java MyRemoteImpl
 * 6:客户根据stub对象调用代理方法,需要stub类，之前利用rmic产生的 
 * 		MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1/RemoteHello"); 
 * 工作方式 从RMIregistry中找Naming.lookup("rmi://127.0.0.1/RemoteHello"); 返回stub对象调用stub方法，获取结果
 * 
 * 扩展获取stub方法：动态类下载，本地下不到从url下
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	private static final long serialVersionUID = 1L;

	protected MyRemoteImpl() throws RemoteException {
	}

	// 不需要声明异常
	public String sayHello() throws RemoteException {
		return "hello";
	}

	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			
			//一定要注册表创建端口
			LocateRegistry.createRegistry(6600);
			// 服务名，注册实例
			Naming.rebind("rmi://192.168.30.1:6600/MyRemote", service);
			/*	
				Context namingContext = new InitialContext();
				namingContext.rebind("//127.0.0.1:6600/MyRemote",
						service);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
