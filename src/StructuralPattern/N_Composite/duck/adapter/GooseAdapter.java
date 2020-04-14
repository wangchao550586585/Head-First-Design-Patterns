package StructuralPattern.N_Composite.duck.adapter;

import StructuralPattern.N_Composite.duck.Quackable;
import StructuralPattern.N_Composite.duck.observer.Observable;
import StructuralPattern.N_Composite.duck.observer.Observer;

/**
 * 适配器模式，鹅伪装鸭子
 */
public class GooseAdapter implements Quackable {
	Goose goose;
	Observable observable;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
		this.observable = new Observable(this);
	}

	@Override
	public void quack() {
		goose.honk();
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
