package org.example.testType;

/**
 当第一次访问类中的静态字段时，会触发类加载，并且
 同一个类只加载一次。静态内部类也是如此，类加载过程由类加载器负责加锁，从而保证线程
 安全。
 * @author Administrator
 *
 */
public class Singleton4 {
	private static class SingletonHolder {
		//静态字段
		public static Singleton4 instance = new  Singleton4();
	}
	private Singleton4() {
	}

	public static Singleton4 newinstance () {
		// 访问静态内部类中的静态字段
		return SingletonHolder.instance;
	}
}
