package StructuralPattern.N_Composite.duck;

import StructuralPattern.N_Composite.duck.observer.Observable;
import StructuralPattern.N_Composite.duck.observer.Observer;

public class RubberDuck implements Quackable {
	Observable observable;

	public RubberDuck() {
		this.observable = new Observable(this);
	}

	public void quack() {
		System.out.println("quack");
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}

}
