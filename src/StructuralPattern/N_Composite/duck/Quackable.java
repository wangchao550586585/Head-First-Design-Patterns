package StructuralPattern.N_Composite.duck;

import StructuralPattern.N_Composite.duck.observer.QuackObservable;

public interface Quackable extends QuackObservable {
	void quack();
}
