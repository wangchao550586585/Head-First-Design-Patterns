package StructuralPattern.N_Composite.duck.observer;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 需要每个鸭类都实现注册与通知，提取封装在此类，只需要鸭类组合这个类即可
 */
public class Observable implements QuackObservable {
	ArrayList<Observer> observers = new ArrayList<Observer>();
	QuackObservable duck;
	//当通知发生时，观察者会把此对象传过去，让观察者知道那个对象在叫notifyObservers().next.update(duck);
	public Observable(QuackObservable duck) {
		this.duck = duck;
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer next = iterator.next();
			next.update(duck);
		}
	}

}
