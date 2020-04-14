package StructuralPattern.N_Composite.duck.factory;

import StructuralPattern.N_Composite.duck.DuckCall;
import StructuralPattern.N_Composite.duck.MallardDuck;
import StructuralPattern.N_Composite.duck.Quackable;
import StructuralPattern.N_Composite.duck.RedheadDuck;
import StructuralPattern.N_Composite.duck.RubberDuck;
import StructuralPattern.N_Composite.duck.adapter.Goose;
import StructuralPattern.N_Composite.duck.adapter.GooseAdapter;

/**
 * 创建不同鸭子
 */
public class DuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}

	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}

	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}

	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}

	@Override
	public Quackable createGooseDuck() {
		return new GooseAdapter(new Goose());
	}
}
