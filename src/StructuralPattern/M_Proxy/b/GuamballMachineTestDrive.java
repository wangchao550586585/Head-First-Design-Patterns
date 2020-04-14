package StructuralPattern.M_Proxy.b;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *代理模式：为另一个对象提供替身或占位符以控制对这个对象的访问
 *
 * 1:GumballMachineRemote 
 * 2：GumballMachine  extends UnicastRemoteObject  implementsGumballMachineRemote,
 * 			提供构造并throws RemoteException 
 * 3：State extends Serializable
 * 4：State不序列化transient GumballMachine gumballMachine; 
 * 5:在bin目录下执行：rmic StructuralPattern.M_Proxy.b.GumballMachine
 * 			生成stub(客户端用)和skeleton(服务器用)
 * 6:在Rmi registry注册
 * 			rmiregistry
 * 			java StructuralPattern.M_Proxy.b.GuamballMachineTestDrive
 * 
 * 远程代理(代理远程服务)：本地调用代理方法，代理通过网络转发到远程执行并获得结果给本地
 * 虚拟代理(创建开销大的对象代表)：虚拟对象在真正需要对象时，才创建对象，对象创建后将请求委托给对象
 * 保护代理：控制对象访问
 * 防火墙代理：控制网络资源的访问，保护主题免于坏客户的侵害
 * 智能引用代理：主题被引用时，进行额外的动作，如计算对象被引用的次数
 * 缓存代理：为开销大的运算结果提供暂时存储，也允许多个客户共享结果，减少网络延迟和计算(web服务器代理，内容管理与出版系统)
 * 同步代理:在多线程的情况下为主题提供安全的访问，场景：javaspace
 * 复杂隐藏代理：用来隐藏一个类的复杂集合的复杂度，并进行访问控制，也称为外观代理
 * 写入时复制代理：用来控制对象的复制，方法是延迟对象的复制，直到客户真正需要的时候，虚拟代理变体(CopyOnWriteArrayList)
 * 
 * 
 */
public class GuamballMachineTestDrive {
	public static void main(String[] args) {
		int count = 0;
		if (args.length < 2) {
			System.out.println("请输入ip地址和糖果数量");
			System.exit(1);
		}
		try {
			count = Integer.parseInt(args[1]);
			GumballMachineRemote gumballMachine = new GumballMachine(args[0], count);
			
			//一定要这步注册端口
			//  rebind(//localhost:port/name,remoteObject);
			LocateRegistry.createRegistry(6600);
			Naming.rebind("//" + args[0] + ":6600/gumballMachine", gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
