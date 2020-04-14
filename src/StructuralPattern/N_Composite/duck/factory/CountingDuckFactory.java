package StructuralPattern.N_Composite.duck.factory;

import StructuralPattern.N_Composite.duck.DuckCall;
import StructuralPattern.N_Composite.duck.MallardDuck;
import StructuralPattern.N_Composite.duck.Quackable;
import StructuralPattern.N_Composite.duck.RedheadDuck;
import StructuralPattern.N_Composite.duck.RubberDuck;
import StructuralPattern.N_Composite.duck.adapter.Goose;
import StructuralPattern.N_Composite.duck.adapter.GooseAdapter;
import StructuralPattern.N_Composite.duck.decker.QuackCounter;

/**
 * 统计鸭子叫的次数
 */
public class CountingDuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}

	@Override
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}

	@Override
	public Quackable createGooseDuck() {
		return new QuackCounter(new GooseAdapter(new Goose()));
	}

}
