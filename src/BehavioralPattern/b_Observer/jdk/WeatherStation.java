package BehavioralPattern.b_Observer.jdk;
/**
 * observerable缺点
 * 1：是类，无法将关键的地方保护起来，由于setChanged()为protected，所以必须继承采用使用此对象
 * 违反第二原则，多用组合，少用继承
 * 
 * PropertyChangeListener:javabean里面的观察者模式
 * 
 *
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		//2个布告板(观察者)
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);
		
		weatherData.setMeasurements(80, 65, 10);
		weatherData.setMeasurements(80, 62, 10);
		
	}
}
