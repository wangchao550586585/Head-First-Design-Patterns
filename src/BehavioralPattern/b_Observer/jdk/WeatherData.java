package BehavioralPattern.b_Observer.jdk;

import java.util.Observable;

public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
	}

	public void measurementsChanged() {
		//notifyObservers()调用之前要先setChanged()表示数据已经改变
		setChanged();
		//使用此方法没有传送数据对象，表示采用的方式是'拉'
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	//数据采用拉的方式，所以需要提供get()
	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
