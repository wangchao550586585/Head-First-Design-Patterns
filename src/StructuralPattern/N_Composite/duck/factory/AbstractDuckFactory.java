package StructuralPattern.N_Composite.duck.factory;

import StructuralPattern.N_Composite.duck.Quackable;

/**
 * 创建不同种类的鸭子
 */
public abstract class AbstractDuckFactory {

	public abstract Quackable createMallardDuck();

	public abstract Quackable createDuckCall();

	public abstract Quackable createRedheadDuck();

	public abstract Quackable createRubberDuck();

	public abstract Quackable createGooseDuck();

}
