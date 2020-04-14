package BehavioralPattern.b_Observer;

import java.util.ArrayList;

interface Subject {
	// 注册观察者
	void registerObserver(Observer o);

	// 删除观察者
	void removeObserver(Observer o);

	// 通知观察者
	void notifyObserver();
}

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObserver() {
		for (int i = observers.size() - 1; i >= 0; i--) {
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	// 当从气象站获得数据，通知观察者
	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
