package BehavioralPattern.b_Observer;



/**
 * 所有的观察者必须实现update(),当气象值观测值改变时，主题会把这些状态值当做方法参数，传送给观察者
 */
interface Observer {

	void update(float temp, float humidity, float pressure);
}

/**
 * 当布告板需要显示时，调用此方法
 *
 */
interface DisplayElement {
	void display();
}

