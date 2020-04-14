package CreationalPattern.E_Singleton;
/**
 * 单例模式：确保一个类只有一个实例，并提供一个全局访问点
 * 管理共享的资源如：线程池，注册表设置，数据库连接池
 * 如果使用多个类加载器，会导致单例失效而产生多个实例
 * 解决方案：自行指定类加载器，并指向同一个类加载器
 * 全局变量缺点
 * 		不能确保只有一个实例
 * 		变量过多导致命名空间污染
 * @author Administrator
 *
 */
public class Singleton {
	private static Singleton uniqueInstance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Singleton();
		return uniqueInstance;
	}

}
