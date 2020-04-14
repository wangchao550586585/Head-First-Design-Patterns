package CreationalPattern.E_Singleton.thread;

/**
 * 多线程解决方案2:不采用延迟实例化
 * 
 * @author Administrator
 *
 */
public class Singleton2 {
	private static Singleton2 uniqueInstance = new Singleton2();

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		return uniqueInstance;
	}

}
