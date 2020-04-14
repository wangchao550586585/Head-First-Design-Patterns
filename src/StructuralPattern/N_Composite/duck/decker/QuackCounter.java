package StructuralPattern.N_Composite.duck.decker;

import StructuralPattern.N_Composite.duck.Quackable;
import StructuralPattern.N_Composite.duck.observer.Observer;

/**
 * 装饰者模式，统计所有鸭子叫的次数
 */
public class QuackCounter implements Quackable {

	Quackable duck;
	static int numberOfQuacks;

	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}

	public static int getNumberOfQuacks() {
		return numberOfQuacks;
	}

	@Override
	public void registerObserver(Observer observer) {
		duck.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		duck.notifyObservers();
	}
}
