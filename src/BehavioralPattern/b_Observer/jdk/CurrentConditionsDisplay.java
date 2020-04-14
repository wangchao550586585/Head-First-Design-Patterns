package BehavioralPattern.b_Observer.jdk;

import java.util.Observable;
import java.util.Observer;

interface DisplayElement {
	void display();
}

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Observable observable;
	private float humidity;
	private float pressure;

	// 将当前对象添加为观察者
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}
	}

	public void display() {
		System.out.println(humidity + " " + pressure);
	}

}
