package CreationalPattern.E_Singleton.thread;

/**
 * 多线程解决方案3:双重检查加锁
 * 
 * @author Administrator
 *
 */
public class Singleton3 {
	// volatile:线程在每次使用变量的时候，都会读取变量修改后的最的值。
	private volatile static Singleton3 uniqueInstance;

	private Singleton3() {
	}

	public static synchronized Singleton3 getInstance() {
		//检查实例，如果不存在就进入同步去
		if (uniqueInstance == null) {
			//只有第一次才彻底执行这里的代码
			synchronized (Singleton3.class) {
				//进入区块后，在检查一次，如果依然是null才创建实例
				if (uniqueInstance == null)
					uniqueInstance = new Singleton3();
			}
		}
		return uniqueInstance;
	}

}
