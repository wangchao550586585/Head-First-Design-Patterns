package StructuralPattern.N_Composite.duck.observer;

/**
 * 观察者模式: 监控某个鸭子的持续叫声
 * 所有的Quackable都实现此接口
 */
public interface QuackObservable {
	void registerObserver(Observer observer);

	void notifyObservers();
}
