package BehavioralPattern.b_Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float pressure;
	private Subject weatherData;// 取消注册时有这个引用会好很多

	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println(temperature + " " + pressure);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.pressure = pressure;
		display();
	}

}
