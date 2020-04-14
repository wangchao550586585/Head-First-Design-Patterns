package CreationalPattern.E_Singleton.thread;

/**
 * 多线程解决方案1
 * 缺点：只有第一次执行方法时才需要同步，设置好uniqueInstance变量，不再需要sync了，之后每次调用都浪费资源
 * 
 * @author Administrator
 *
 */
public class Singleton1 {
	private static Singleton1 uniqueInstance;

	private Singleton1() {
	}

	public static synchronized Singleton1 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Singleton1();
		return uniqueInstance;
	}

}
