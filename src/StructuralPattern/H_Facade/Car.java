package StructuralPattern.H_Facade;

import java.util.ArrayList;

/**
 * 遵守最少知识原则，案例
 */
public class Car {
	Engine engine;

	public void start(Key key) {
		Doors doors = new Doors();
		boolean authorized = key.turns();// 被当做参数传递进来的对象，其方法可以被调用
		if (authorized) {
			engine.start();// 调用组件方法
			updateDashboardDisplay();// 调用同一个对象内的本地方法
			doors.lock();// 调用所创建或实例化的对象的方法
		}
		// 这样不行，没有遵守最小知识原则，因为在此调用的方法属于另一次调用的返回对象
		// key.getObject().size();
		// 但是可以再key里面添加一个显示size()结果的方法，这样可以减少所依赖的类的数目
		int size = key.getSize();
	}

	private void updateDashboardDisplay() {

	}
}

class Engine {
	public void start() {
	}
}

class Doors {
	public void lock() {
	}
}

class Key {
	public boolean turns() {
		return false;
	}

	public ArrayList getObject() {
		return new ArrayList();
	}

	public int getSize() {
		return new ArrayList().size();
	}
}
