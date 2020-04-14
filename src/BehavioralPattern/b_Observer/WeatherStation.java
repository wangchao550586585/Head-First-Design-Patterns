package BehavioralPattern.b_Observer;

/**
 * 观察者模式:定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，他的所有依赖都会收到通知并自动更新 (如：MVC)
 * 设计原则：为了交互对象之间的松耦合设计努力
 * 出版者+订阅者=观察者模式 设计原则：低耦合，高内聚
 * 
 * 对于每一个设计原则，请描述观察者模式如何遵循此原则。
 * 设计原则:找出程序中会变化的方面，然后将其和固定不变的方面相分离。
 * 		在观察者模式中，会改变的是主题的状态，以及观察者的数目和类型。用这个模式，你可以改变依赖于主题状态的对象，却不必改变主题。这就叫提前规划！
 * 设计原则:针对接口编程，不针对实现编程。
 * 		主题与观察者都使用接口：观察者利用主题的接口向主题注册，而主题利用观察者接口通知观察者。这样可以让两者之间运作正常，又同时具有松耦合的优点。
 * 设计原则:多用组合，少用继承。
 * 		观察者模式利用“组合”将许多观察者组合进主题中。对象之间的这种关系不是通过继承产生的，而是在运行时利用组合的方式而产生的。
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		// 2个布告板(观察者)
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 10);
		weatherData.setMeasurements(80, 62, 10);

	}
}
